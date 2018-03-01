from AST.base_node import BaseNode
from PyQt5.QtWidgets import QLabel, QLineEdit


class QuestionNode(BaseNode):
    def __init__(self, line_number, label, identifier, answer_type, answer):
        super(QuestionNode, self).__init__(line_number)
        self.__label = label
        self.__identifier = identifier
        self.__answer_type = answer_type
        self.__answer = answer

    @property
    def label(self):
        return self.__label

    @property
    def identifier(self):
        return self.__identifier

    @property
    def answer_type(self):
        return self.__answer_type

    @property
    def answer(self):
        return self.__answer

    def pyqt5_render(self, layout):
        layout.addRow(QLabel(self.label), self.answer_type.pyqt5_default_widget())

