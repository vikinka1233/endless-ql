﻿using System;
using System.Collections;
using NUnit.Framework;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;

namespace QL.UnitTests.Domain.UnitTests.Data
{
    public static class TestValidationData
    {
        public static IEnumerable RepeatedNamesDifferentTypes
        {
            get
            {
                yield return new TestCaseData(
                    @"form John { q: ""i""  date q: ""2"" string}",
                    new IQuestionType[] {new DateQuestionType(), new StringQuestionType()},
                    @"The Question identifier 'q' is used multiple times with different types");

                yield return new TestCaseData(
                    @"form Matthew { x: ""i"" integer x: ""2"" decimal x: ""3"" string }",
                    new IQuestionType[] {new IntegerQuestionType(), new DecimalQuestionType(), new StringQuestionType()},
                    @"The Question identifier 'x' is used multiple times with different types");

                yield return new TestCaseData(
                    @"form Matthew { xj: ""i"" integer xj: ""2"" decimal xj: ""3"" decimal }",
                    new IQuestionType[] {new IntegerQuestionType(), new DecimalQuestionType(), new DecimalQuestionType()},
                    @"The Question identifier 'xj' is used multiple times with different types");
            }
        }

        public static IEnumerable RepeatedNamesSameTypes
        {
            get
            {
                yield return new TestCaseData(
                    @"form John { q: ""i""  date q: ""2"" date}");

                yield return new TestCaseData(
                    @"form Matthew { x: ""i"" integer x: ""2"" integer x: ""3"" integer }");
            }
        }
        
        public static IEnumerable UndefinedVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Luke { q: ""i"" integer=(pj+3)}",
                    @"The variable 'pj' has not been defined");

                yield return new TestCaseData(
                    @"form Mark { q: ""i"" integer if (j) { q2: ""i"" integer} }",
                    @"The variable 'j' has not been defined");
            }
        }

        public static IEnumerable NonBooleanConditionVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Phil { pm: ""i"" integer if (pm) { q2: ""i"" integer} }",
                    $@"The variable 'pm' is in a condition but is not a bool, it is '{new IntegerQuestionType()}'");

                yield return new TestCaseData(
                    @"form Grant { gm: ""i"" date if (gm) { q2: ""i"" integer} }",
                    $@"The variable 'gm' is in a condition but is not a bool, it is '{new DateQuestionType()}'");

                yield return new TestCaseData(
                    @"form Peggy { pm: ""i"" decimal if (pm) { q2: ""i"" integer} }",
                    $@"The variable 'pm' is in a condition but is not a bool, it is '{new DecimalQuestionType()}'");

                yield return new TestCaseData(
                    @"form Sam { sm: ""i"" string if (sm) { q2: ""i"" integer} }",
                    $@"The variable 'sm' is in a condition but is not a bool, it is '{new StringQuestionType()}'");

                yield return new TestCaseData(
                    @"form Billy { bm: ""i"" integer if (bm && True) { q2: ""i"" integer} }",
                    $@"The variable 'bm' is in a condition but is not a bool, it is '{new IntegerQuestionType()}'");

                yield return new TestCaseData(
                    @"form Sharron { sm: ""i"" date if (False || sm) { q2: ""i"" integer} }",
                    $@"The variable 'sm' is in a condition but is not a bool, it is '{new DateQuestionType()}'");

                yield return new TestCaseData(
                    @"form Tiffany { tm: ""i"" decimal if (!tm) { q2: ""i"" integer} }",
                    $@"The variable 'tm' is in a condition but is not a bool, it is '{new DecimalQuestionType()}'");
            }
        }

        public static IEnumerable NonDateConditionVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Arthur { af: ""i"" integer if (19/02/1985 == af) { q2: ""i"" integer} }",
                    $@"The variable 'af' is in a date comparison but is not a date, it is '{new IntegerQuestionType()}'");

                yield return new TestCaseData(
                    @"form Pauleen { pf: ""i"" boolean if (pf != 19/2/85) { q2: ""i"" integer} }",
                    $@"The variable 'pf' is in a date comparison but is not a date, it is '{new BooleanQuestionType()}'");

                yield return new TestCaseData(
                    @"form Mark { mf: ""i"" decimal if (mf > 14/02/2003) { q2: ""i"" integer} }",
                    $@"The variable 'mf' is in a date comparison but is not a date, it is '{new DecimalQuestionType()}'");

                yield return new TestCaseData(
                    @"form Michelle { mf: ""i"" string if (31/12/94 <= mf) { q2: ""i"" integer} }",
                    $@"The variable 'mf' is in a date comparison but is not a date, it is '{new StringQuestionType()}'");
            }
        }
        
        public static IEnumerable NonTextConditionVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Ian { ib: ""i"" integer if (""a string"" == ib) { q2: ""i"" integer} }",
                    $@"The variable 'ib' is in a string comparison but is not a string, it is '{new IntegerQuestionType()}'");

                yield return new TestCaseData(
                    @"form Kathy { kb: ""i"" boolean if (kb != ""another sting"") { q2: ""i"" integer} }",
                    $@"The variable 'kb' is in a string comparison but is not a string, it is '{new BooleanQuestionType()}'");
               }
        }

        public static IEnumerable NonNumericConditionVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Ricky { rb: ""i"" date if (1 == rb) { q2: ""i"" integer} }",
                    $@"The variable 'rb' is in a number comparison but is not a number, it is '{new DateQuestionType()}'");

                yield return new TestCaseData(
                    @"form Pat { pb: ""i"" string if (pb != 10.5) { q2: ""i"" integer} }",
                    $@"The variable 'pb' is in a number comparison but is not a number, it is '{new StringQuestionType()}'");

                yield return new TestCaseData(
                    @"form Frank { fb: ""i"" boolean if (-200 <= fb) { q2: ""i"" integer} }",
                    $@"The variable 'fb' is in a number comparison but is not a number, it is '{new BooleanQuestionType()}'");

                yield return new TestCaseData(
                    @"form Bianca { bb: ""i"" date if (bb > -365.25) { q2: ""i"" integer} }",
                    $@"The variable 'bb' is in a number comparison but is not a number, it is '{new DateQuestionType()}'");
            }
        }


        public static IEnumerable RepeatedText
        {
            get
            {
                yield return new TestCaseData(
                    @"form John { q1: ""RepeatedText""  date q2: ""RepeatedText"" string}",
                    @"The text 'RepeatedText' is used multiple times");

                yield return new TestCaseData(
                    @"form Peter { qx1: ""blah""  date qx2: ""blah"" string}",
                    @"The text 'blah' is used multiple times");
            }
        }

        public static IEnumerable NoCyclicDependency
        {
            get
            {
                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(10)}");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(10) q2: ""second?"" integer=(q1) }");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q2) q2: ""second?"" integer=(99) }");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q2) q2: ""second?"" integer=(q3) q3: ""third?"" integer=(99) }");
                
                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q4) q2: ""second?"" integer=(q3) q3: ""third?"" integer=(99) q4: ""fourth?"" integer=(q3) }");

                yield return new TestCaseData(
                    @"
form ComplexNonCyclic1 {
  a: ""a"" integer=(b+c)
  b: ""b"" integer=(d+e)
  c: ""c"" integer=(f+g)
  d: ""d"" integer=(f+g+c)
  e: ""e"" integer=(y)
  f: ""f"" integer=(x+y)
  g: ""g"" integer=(e+x+x+10)
  x: ""x"" integer=(10)
  y: ""y"" integer
}");
                yield return new TestCaseData(
                    @"
form ComplexNonCyclic2 {
  d: ""d"" integer=(f+g+c)
  c: ""c"" integer=(f+g)
  y: ""y"" integer
  f: ""f"" integer=(x+y)
  g: ""g"" integer=(e+x+x+10)
  a: ""a"" integer=(b+c)
  x: ""x"" integer=(10)
  e: ""e"" integer=(y)
  b: ""b"" integer=(d+e)
}");


            }
        }

        public static IEnumerable CyclicDependency
        {
            get
            {
                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q1)}",
                    @"a cirular dependency was found");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q1 +100)}",
                    @"a cirular dependency was found");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=((300 / 10) + (q1 +100))}",
                    @"a cirular dependency was found");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q2) q2: ""second?"" integer=(q1)}",
                    @"a cirular dependency was found");

                yield return new TestCaseData(
                    @"form John { q1: ""first?"" integer=(q2) q2: ""second?"" integer=(q3) q3: ""third?"" integer=(q1)}",
                    @"a cirular dependency was found");


                yield return new TestCaseData(
                    @"
form ComplexCyclic1 {
  a: ""a"" integer=(b+c)
  b: ""b"" integer=(d+e)
  c: ""c"" integer=(f+g)
  d: ""d"" integer=(f+g+c)
  e: ""e"" integer=(y)
  f: ""f"" integer=(x+y)
  g: ""g"" integer=(e+x+x+10)
  x: ""x"" integer=(10)
  y: ""y"" integer=(a)
}"
                    , @"a cirular dependency was found");
            }
        }

        public static IEnumerable NonNumberCalculationVariable
        {
            get
            {
                yield return new TestCaseData(
                    @"form Charlie { cs: ""i"" boolean clc: ""c"" decimal  = (cs) }",
                    $@"The variable 'cs' is in a calculation but is not a number, it is '{new BooleanQuestionType()}'");

                yield return new TestCaseData(
                    @"form Kat { ks: ""i"" date clc: ""c"" decimal  = (ks) }",
                    $@"The variable 'ks' is in a calculation but is not a number, it is '{new DateQuestionType()}'");

                yield return new TestCaseData(
                    @"form Zoe { zs: ""i"" string clc: ""c"" decimal  = (zs) }",
                    $@"The variable 'zs' is in a calculation but is not a number, it is '{new StringQuestionType()}'");

                yield return new TestCaseData(
                    @"form LittleMo { lms: ""i"" boolean clc: ""c"" decimal  = (lms + 100) }",
                    $@"The variable 'lms' is in a calculation but is not a number, it is '{new BooleanQuestionType()}'");

                yield return new TestCaseData(
                    @"form Lynne { ls: ""i"" date clc: ""c"" decimal  = (99 - ls) }",
                    $@"The variable 'ls' is in a calculation but is not a number, it is '{new DateQuestionType()}'");

                yield return new TestCaseData(
                    @"form Viv { vs: ""i"" string clc: ""c"" decimal  = (123.45 * vs) }",
                    $@"The variable 'vs' is in a calculation but is not a number, it is '{new StringQuestionType()}'");

                yield return new TestCaseData(
                    @"form Luke { ls: ""i"" string clc: ""c"" decimal  = (ls / -999.25) }",
                    $@"The variable 'ls' is in a calculation but is not a number, it is '{new StringQuestionType()}'");
            }
        }

        public static IEnumerable UnKnownVariables
        {
            get
            {
                const string template = @"form formName {{ v1: ""i"" {0} v2: ""c"" {1} if ({2}) {{ a: ""a"" date}} }}";

                const string relationalErrorTemplate = @"The expression '{0}' contains the {1} variables 'v1' and 'v2'. A {1} can only be compared for equality.";

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"boolean", @"v1 > v2"),
                    string.Format(relationalErrorTemplate, @"v1>v2", @"boolean"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"boolean", @"v1 >= v2"),
                    string.Format(relationalErrorTemplate, @"v1>=v2", @"boolean"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"boolean", @"v1 < v2"),
                    string.Format(relationalErrorTemplate, @"v1<v2", @"boolean"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"boolean", @"v1 <= v2"),
                    string.Format(relationalErrorTemplate, @"v1<=v2", @"boolean"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"string", @"v1 > v2"),
                    string.Format(relationalErrorTemplate, @"v1>v2", @"string"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"string", @"v1 >= v2"),
                    string.Format(relationalErrorTemplate, @"v1>=v2", @"string"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"string", @"v1 < v2"),
                    string.Format(relationalErrorTemplate, @"v1<v2", @"string"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"string", @"v1 <= v2"),
                    string.Format(relationalErrorTemplate, @"v1<=v2", @"string"));

                const string typeMismatchTemplate = @"The expression '{0}' contains the {1} variable 'v1' and {2} variable 'v2'. The types {1} and {2} cannot be compared.";

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"string", @"v1 == v2"),
                    string.Format(typeMismatchTemplate, @"v1==v2", @"boolean", @"string"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"integer", @"v1 != v2"),
                    string.Format(typeMismatchTemplate, @"v1!=v2", @"boolean", @"integer"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"decimal", @"v1 == v2"),
                    string.Format(typeMismatchTemplate, @"v1==v2", @"boolean", @"decimal"));

                yield return new TestCaseData(
                    string.Format(template, @"boolean", @"date", @"v1 != v2"),
                    string.Format(typeMismatchTemplate, @"v1!=v2", @"boolean", @"date"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"integer", @"v1 < v2"),
                    string.Format(typeMismatchTemplate, @"v1<v2", @"string", @"integer"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"decimal", @"v1 > v2"),
                    string.Format(typeMismatchTemplate, @"v1>v2", @"string", @"decimal"));

                yield return new TestCaseData(
                    string.Format(template, @"string", @"date", @"v1 <= v2"),
                    string.Format(typeMismatchTemplate, @"v1<=v2", @"string", @"date"));

                yield return new TestCaseData(
                    string.Format(template, @"integer", @"date", @"v1 >= v2"),
                    string.Format(typeMismatchTemplate, @"v1>=v2", @"integer", @"date"));

                yield return new TestCaseData(
                    string.Format(template, @"decimal", @"date", @"v1 != v2"),
                    string.Format(typeMismatchTemplate, @"v1!=v2", @"decimal", @"date"));
            }
        }
    }
}