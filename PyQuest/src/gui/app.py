from ql.parser.qllex import LexTokenizer
from ql.parser.qlyacc import QLParser
from ql.ast.visitors.render import Render
from ql.ast.visitors.reference_visitor import ReferenceVisitor
from ql.ast.visitors.dependency_visitor import DependencyVisitor
from ql.ast.visitors.question_visitor import QuestionVisitor
from ql.ast.visitors.identifier_visitor import IdentifierVisitor
from ql.ast.visitors.label_visitor import LabelVisitor
from ql.ast.visitors.identifier_type_visitor import IdentifierTypeVisitor
from ql.ast.visitors.type_checker import TypeChecker
from ql.ast.checkers.label_checker import LabelChecker
from ql.ast.checkers.identifier_checker import IdentifierChecker
from ql.ast.checkers.question_checker import QuestionChecker
from ql.ast.checkers.dependency_checker import DependencyChecker
from ql.ast.checkers.reference_checker import ReferenceChecker
from gui.form import Form
from gui.helper import append_file_extension
from PyQt5.QtGui import QIcon
from PyQt5.QtWidgets import QTextEdit
from PyQt5.QtWidgets import QFileDialog
from PyQt5.QtWidgets import QMainWindow
from PyQt5.QtWidgets import QApplication
from PyQt5.QtWidgets import QAction
from PyQt5.QtWidgets import QMessageBox
from sys import exit
from sys import argv


class MainApp(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle('PyQuest')
        self.current_file = None
        self.create_menu_bar()
        self.text_edit = QTextEdit()
        self.setCentralWidget(self.text_edit)

        self.show()

    def create_menu_bar(self):
        menu_bar = self.menuBar()

        new_file = QAction(QIcon(), 'New', self)
        new_file.setShortcut('Ctrl+N')
        new_file.setStatusTip('New file')
        new_file.triggered.connect(self.new_file)

        open_file = QAction(QIcon(), 'Open', self)
        open_file.setShortcut('Ctrl+O')
        open_file.setStatusTip('Open file')
        open_file.triggered.connect(self.open_file)

        save = QAction(QIcon(), 'Save', self)
        save.setShortcut('Ctrl+S')
        save.setStatusTip('Save file')
        save.triggered.connect(self.save)

        save_file = QAction(QIcon(), 'Save as', self)
        save_file.setShortcut('Ctrl+Shift+S')
        save_file.setStatusTip('Save file as')
        save_file.triggered.connect(self.save_file)

        create_form = QAction(QIcon(), 'Create form', self)
        create_form.setShortcut('Ctrl+R')
        create_form.setStatusTip('Create form')
        create_form.triggered.connect(self.create_form)

        file_menu = menu_bar.addMenu('&File')
        file_menu.addAction(new_file)
        file_menu.addAction(open_file)
        file_menu.addAction(save)
        file_menu.addAction(save_file)

        create_menu = menu_bar.addMenu('&Create')
        create_menu.addAction(create_form)

    def new_file(self):
        self.current_file = None
        self.text_edit.setText('')

    def open_file(self):
        self.current_file, _ = QFileDialog.getOpenFileName(caption='Open file', directory='/home',
                                                           filter="Questionnaire language files (*.ql)")

        if self.current_file:
            with open(self.current_file, 'r') as file:
                self.text_edit.setText(file.read())

    def save(self):
        if self.current_file:
            with open(self.current_file, 'w') as file:
                file.write(self.text_edit.toPlainText())
        else:
            self.save_file()

    def save_file(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        file_name, _ = QFileDialog.getSaveFileName(caption='Save file as', directory='/home',
                                                   filter='Questionnaire language files (*.ql)', options=options)

        if file_name:
            self.current_file = append_file_extension(file_name, 'ql')
            with open(self.current_file, 'w') as file:
                file.write(self.text_edit.toPlainText())

    def create_form(self):
        textbox_value = self.text_edit.toPlainText()
        parser = QLParser()
        lexer = LexTokenizer()

        try:
            ast = parser.parser.parse(textbox_value, lexer.lexer)

            reference_visitor = ReferenceVisitor()
            reference_visitor.visit(ast)
            ReferenceChecker(reference_visitor.scope)

            dependency_visitor = DependencyVisitor()
            dependency_visitor.visit(ast)
            DependencyChecker(dependency_visitor.combinations)

            question_visitor = QuestionVisitor()
            question_visitor.visit(ast)
            QuestionChecker(question_visitor.questions)

            identifier_visitor = IdentifierVisitor()
            identifier_visitor.visit(ast)
            IdentifierChecker(identifier_visitor.identifiers)

            label_visitor = LabelVisitor()
            label_visitor.visit(ast)
            LabelChecker(label_visitor.labels)

            identifier_type_visitor = IdentifierTypeVisitor()
            identifier_type_visitor.visit(ast)
            type_checker = TypeChecker(identifier_type_visitor.label_type_combinations)
            type_checker.visit(ast)

            visitor = Render()
            visitor.visit(ast)

            dialog = Form(visitor.form)
            dialog.exec_()
        except:
            QMessageBox.warning(QMessageBox(), 'Warning', 'Unable to create form.',
                                QMessageBox.Close, QMessageBox.Escape)


if __name__ == '__main__':
    app = QApplication(argv)
    ex = MainApp()
    exit(app.exec_())