from PyQt5.QtWidgets import *
from PyQt5 import QtCore
import os,sys
sys.path.insert(1, os.path.join(sys.path[0], '..'))
from gui import gui
from pytestqt import qtbot

def testfunc(qtbot):
    app = QApplication(sys.argv)
    screen = gui.InputWindow()
    screen.show()

    file = open("output.txt","w")
    file.write("hi")
    file.close()

    screen.qlInput.setText("form Box1HouseOwning {\n hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n}")
    qtbot.mouseClick(screen.parsebutton, QtCore.Qt.LeftButton)
    qtbot.mouseClick(screen.output.submitbutton, QtCore.Qt.LeftButton)
    qtbot.mouseClick(screen.quitbutton, QtCore.Qt.LeftButton)

    file = open("output.txt")
    testtext = file.read()
    file.close()
    os.remove("output.txt")

    assert testtext == '"Did you sell a house in 2010?"undefined\n"Did you by a house in 2010?"undefined\n"Did you enter a loan for maintenance/reconstruction?"undefined\n'
