from tkinter import ttk
from decimal import Decimal, InvalidOperation
from util.values import *


class ValidatingEntry(ttk.Entry):

    def __init__(self, parent, **kw):
        super().__init__(parent, validate='all', validatecommand=(parent.register(self.validate), '%P'), **kw)  #

    def validate(self, new_value):
        return new_value


class IntegerWidget(ValidatingEntry):

    def __init__(self, parent, identifier, value=""):
        super().__init__(parent, width=20, name=identifier)
        super().insert(0, value)

    def get(self):
        try:
            return IntegerValue(super().get())
        except ValueError:
            return None

    def validate(self, new_value):
        if new_value == "":
            return True
        try:
            print(new_value)
            if int(new_value) == int(new_value):
                return True
        except ValueError:
            return False
        return False

    def __repr__(self):
        return "IntegerWidget"


class DecimalWidget(ValidatingEntry):

    def __init__(self, parent, identifier, value=""):
        super().__init__(parent, width=20, name=identifier)
        print("widgetValue", value)
        super().insert(0, value)

    def get(self):
        try:
            return DecimalValue(super().get())
        except (ValueError, InvalidOperation):
            return None

    def validate(self, new_value):
        if new_value == "":
            return True
        try:
            if Decimal(new_value) == Decimal(new_value):
                return True
        except (ValueError, InvalidOperation):
            return False
        return False

    def __repr__(self):
        return "DecimalWidget"


class MoneyWidget(ValidatingEntry):

    def __init__(self, parent, identifier, value=""):
        super().__init__(parent, width=20, name=identifier)
        super().insert(0, value)

    def get(self):
        try:
            return MoneyValue(super().get())
        except (ValueError, InvalidOperation):
            return None

    def validate(self, new_value):
        if new_value == "":
            return True
        try:
            is_decimal = Decimal(new_value) == Decimal(new_value)
            exponent = Decimal(new_value).as_tuple().exponent
            if is_decimal and exponent >= -2:
                return True
        except (ValueError, InvalidOperation):
            return False
        return False

    def __repr__(self):
        return "MoneyWidget"


class StringWidget(ttk.Entry):

    def __init__(self, parent, identifier, value=""):
        super().__init__(parent, width=20, name=identifier)
        super().insert(0, value)

    def get(self):
        try:
            return StringValue(super().get())
        except ValueError:
            return None

    def __repr__(self):
        return "StringWidget"


class BooleanWidget(ttk.Checkbutton):

    def __init__(self, parent, identifier, value=False):
        self._value = tk.IntVar()

        if value:
            self._value.set(1)
        else:
            self._value.set(0)
        super().__init__(parent, width=20, name=identifier, command=(parent.register(self.onchange)),
                         variable=self._value)
        self.onchange()

    def get(self):
        try:
            return BooleanValue(self._value.get())
        except ValueError:
            return None

    def onchange(self):
        selected = self._value.get()
        if selected:
            self.config(text="yes")
        else:
            self.config(text="no")

    def __repr__(self):
        return "BooleanWidget"


class RadioWidget(ttk.Frame):

    def __init__(self, parent, identifier, state=False):
        super().__init__(parent, name=identifier)
        print("radio", state, type(state))
        self.root = parent

        self._state = tk.BooleanVar()
        if state:
            self._state.set(True)

        self._radio_yes = tk.Radiobutton(self, text="yes", variable=self._state, value=True)
        self._radio_no = tk.Radiobutton(self, text="no", variable=self._state, value=False)

        self._radio_yes.grid(column=0, row=0, padx=5)
        self._radio_no.grid(column=1, row=0, padx=5)

    def get(self):
        print("self._state", self._state.get())
        try:
            return BooleanValue(self._state.get())
        except ValueError:
            return None

    def __repr__(self):
        return "RadioWidget"
