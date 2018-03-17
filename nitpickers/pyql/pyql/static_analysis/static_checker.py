from pyql.static_analysis.duplication import CheckDuplicatedQuestions
from pyql.static_analysis.dependency import VariableDependenciesChecker


class StaticChecker:
    def __init__(self):
        self._messages = []

    def run(self, tree):
        self._messages = []

        print("****** Check Duplicated Questions *****")
        cdq = CheckDuplicatedQuestions()
        self._messages.extend(cdq.check(tree))

        print("****** Variable Dependencies Checker ******")
        vdc = VariableDependenciesChecker(tree)
        self._messages.extend(vdc.check())

    def messages(self):
        return self._messages
        # stb = SymbolTableBuilder()
        # st = stb.build_from_tree(c)
        #
        # print(st)
        #
        # vv = ASTVisitor(stb.symbol_table)
        # c.accept(vv)