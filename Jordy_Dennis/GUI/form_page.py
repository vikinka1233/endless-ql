"""
    Pages can be added to a parent class and consist of a scrollFrame (contents), to which
    questions can be added or removed.

    We track a list of questions, in case questions need to be removed or added
"""
from .gui_imports import *
from .form_question import Question
from .form_scroll_frame import ScrollFrameGui
from .form_question import Question
from .form_section import *


class Page():

    def __init__(self, parent, questionGenerator, page_header='default', color='green'):
        self.questionGenerator = questionGenerator
        self.frame = create_frame(parent, color)
        self.frame.pack(expand=True, fill='both')
        self.sfg = ScrollFrameGui(self.frame)
        self.contents = self.sfg.get_contents()
        self.sections = []

    """
        Lifts the frame in case the menu button of the frame is pressed
    """

    def show(self):
        self.frame.lift()

    """
        Place the frame inside parent frame
    """

    def place(self, parent, x=0, y=0, relwidth=1, relheight=1):
        self.frame.place(in_=parent, x=x, y=y, relwidth=relwidth, relheight=relheight)

    """
        Create a section in a Page
    """

    def createSection(self, header='default'):
        section = Section(self.contents, self.questionGenerator, header)
        self.sections.append(section)

    """
        Add a question from the question generator
    """

    def addQuestionToSection(self, sectionName, varName, questionText="Default Question", questionType=bool, value=False, prev=""):
        for section in self.sections:
            print("HALLO")
            print(section.getName(), sectionName)
            if section.name == sectionName:
                section.insertQuestion(prev, self.questionGenerator, varName, questionText, questionType, value)
    """
        Remove a question if it exists in our questions
    """
    def removeQuestionFromSection(self, sectionName, varName):
        for section in self.sections:
            if section.getName() == sectionName:
                section.removeQuestion(varName)

    def emptyFrame(self):
        f = self.sfg.getFrame()
        f.destroy()
        self.sfg = ScrollFrameGui(self.frame)
        self.contents = self.sfg.getContents()
        return self.contents

    def getFrame(self):
        return self.frame

    def getContents(self):
        return self.contents
