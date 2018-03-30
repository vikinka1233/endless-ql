from src.test.test import Test


class TestLexing(Test):
    def __init__(self, name, directory, lexer):
        super(TestLexing, self).__init__(name, directory)
        self.lexer = lexer

    def test_file(self, file):
        self.lexer.test(file)

        if self.lexer.errors:
            return False

        return True
