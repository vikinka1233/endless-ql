/*
    Form with cyclical dependencies
*/

form cyclical {
	"Variable based on second answer:" first: integer = (second + 2)
	"Variable based on first answer:" second: integer = (first - 2)

    "First variable based on itself:" third: integer = (third + 2)
    "Second variable based on itself:" fourth: integer = (fourth - 2)


}