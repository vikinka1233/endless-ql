# -*- coding: utf-8 -*-
import logging

from functools import reduce
from parse.combinators import *
from lexer.ql_lexer import *
from ast.ql_ast import *


logger = logging.getLogger(__name__)


# Top level parser
def ql_parser(tokens):
    ql_ast = parser()(tokens, 0)
    return ql_ast


def parser():
    return Phrase(stmt_list())


# Statements
def stmt_list():
    separator = keyword('\n') ^ (lambda x: lambda l, r: CompoundStatement(l, r))
    return Exp(stmt(), separator)


# Basic parsers

def keyword(kw):
    return Reserved(kw, 'reserved')


# Helper

def get_tags():
    num = Tag('int') ^ (lambda i: int(i))
    id = Tag('id')
    value = Tag('value')
    boolean = Tag('boolean')
    form = Tag('form')
    return num, id, value, boolean, form


# Statements
def stmt():
    """
    Possible paterns to be recognized
    """
    return form_stmt() | assign_stmt()  # | if_stmt()


def form_stmt():
    """
    form Box1HouseOwning {...}
    """
    def process(parsed):
        ((((((_, name), _), _), parsed_form), _), _) = parsed
        return FormStatement(name, parsed_form)

    num, id, value, boolean, form = get_tags()
    return form + id + keyword('{') + keyword('\n') + Lazy(stmt_list) + keyword('\n') + keyword('}') ^ process


def assign_stmt():
    """
    hasSoldHouse: "Did you sell a house in 2010?" boolean
    """
    def process(parsed):
        (((name, _), question), data_type) = parsed
        return AssignStatement(name, question, data_type)

    num, id, value, boolean, form = get_tags()
    return id + keyword(':') + value + keyword('boolean') ^ process


def if_stmt():
    """
    if (hasSoldHouse) {...}
    """
    # todo
    def process(parsed):
        (((((_, condition), _), true_stmt), false_parsed), _) = parsed
        if false_parsed:
            (_, false_stmt) = false_parsed
        else:
            false_stmt = None
        return IfStatement(condition, true_stmt, false_stmt)
    return keyword('if') + bexp() + keyword('then') + Lazy(stmt_list) + \
           Opt(keyword('else') + Lazy(stmt_list)) + keyword('end') ^ process


# Boolean expressions
# def bexp():
#     return precedence(bexp_term(),
#                       bexp_precedence_levels,
#                       process_logic)
#
#
# def bexp_term():
#     return bexp_not() | \
#            bexp_relop() | \
#            bexp_group()
#
#
# def bexp_not():
#     return keyword('not') + Lazy(bexp_term) ^ (lambda parsed: NotBexp(parsed[1]))
#
#
# def bexp_relop():
#     relops = ['<', '<=', '>', '>=', '=', '!=']
#     return aexp() + any_operator_in_list(relops) + aexp() ^ process_relop
#
#
# def bexp_group():
#     return keyword('(') + Lazy(bexp) + keyword(')') ^ process_group


# Arithmetic expressions
# def aexp():
#     return precedence(aexp_term(),
#                       aexp_precedence_levels,
#                       process_binop)
#
#
# def aexp_term():
#     return aexp_value() | aexp_group()
#
#
# def aexp_group():
#     return keyword('(') + Lazy(aexp) + keyword(')') ^ process_group
#
#
# def aexp_value():
#     return (num ^ (lambda i: IntAexp(i))) | \
#            (id ^ (lambda v: VarAexp(v)))
#
#
# # Combinator for binary operator expressions (aexp and bexp)
# def precedence(value_parser, precedence_levels, combine):
#     def op_parser(precedence_level):
#         return any_operator_in_list(precedence_level) ^ combine
#
#     parser = value_parser * op_parser(precedence_levels[0])
#     for precedence_level in precedence_levels[1:]:
#         parser = parser * op_parser(precedence_level)
#     return parser
#
#
# # Miscellaneous functions for binary and relational operators
# def process_binop(op):
#     return lambda l, r: BinopAexp(op, l, r)
#
#
# def process_relop(parsed):
#     ((left, op), right) = parsed
#     return RelopBexp(op, left, right)
#
#
# def process_logic(op):
#     if op == 'and':
#         return lambda l, r: AndBexp(l, r)
#     elif op == 'or':
#         return lambda l, r: OrBexp(l, r)
#     else:
#         raise RuntimeError('unknown logic operator: ' + op)
#
#
# def process_group(parsed):
#     ((_, p), _) = parsed
#     return p
#
#
# def any_operator_in_list(ops):
#     op_parsers = [keyword(op) for op in ops]
#     parser = reduce(lambda l, r: l | r, op_parsers)
#     return parser
#
#
# # Operator keywords and precedence levels
# aexp_precedence_levels = [
#     ['*', '/'],
#     ['+', '-'],
# ]
#
# bexp_precedence_levels = [
#     ['and'],
#     ['or'],
# ]