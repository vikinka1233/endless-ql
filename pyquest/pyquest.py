from sys import argv
from sys import exit

from PyQt5.QtWidgets import QApplication

from gui.main_window import MainWindow

if __name__ == '__main__':
    app = QApplication(argv)
    ex = MainWindow()
    exit(app.exec_())