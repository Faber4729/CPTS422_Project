**Deliverable 3:**

**CommentCountCheck**
<br>  Code: Gets the total number of // and /* tokens.
> I assuemd all comments started with /* would finish, and count as a comment. I also assumed there would be no comments such as:
> // example // I like adding these //

 Tests:


**CommentLineCountCheck**
<br>  Code: Gets the total number of // and the number of lines between /* and */ tokens.
> In this, I also assumed there would be no comments like above, or like:
> /*
> /* Look, some text
> * Still going */
> * Continuing on */

Tests:


**ExpressionCountCheck**
<br>  Code: Gets all lines with at least one of: +, -, *, %, /; each line is counted as 1, no matter how many of these characters are in it.
> I assuemd that an expression would be kept on one line and only use basic arithmetic values in it. I did not count something like i += 1 as an expression.
<Tests:
  
**LoopCountCheck**
<br>  Code: Gets all tokens with the text "for", "foreach", "while", and "do while".
> For the tokens here, my assumption was that only the for/while loops would count as loops, and something that referred back to itself didn't.<

Tests:


**OperandCountCheck**
<br>  Code: Gets all tokens that are variables, doubles, floats, integers, strings, and true/false. Also, records the amount of unique characters from that list, by comparing each new token to previously found ones.
> This metric at least covers the basic examples of an operand, as something I assumed could be edited or throwing into an equivalency (aside from classes) or equation.

Tests:


**OperatorCountCheck**
<br>Code: Gets all tokens included in: +, -, *, /, %, ++, --, ==, !=, >>>, <<<, >, <, >=, <=, ^, |, ||, &&, ^=, +=, -=, /=, *=, %=, >>>=, |=, ||=. Also, records the amount of unique characters from that list, by comparing each new token to previously found ones.
> For the operators, this list isn't exhaustive, but I defined the operators as anything that either was part of an equation, or did something to edit or change some previous value.

Tests:


**HalsteadChecks**
<br>Code: Each Halstead Check differs only in their methods for getting/calculating the metric values; the Halstead length gets the toal amount of operands and operators, the vocabulary is the total knumber of unique operators and operands, the volume is the Halstead length * log_2(vocabulary), the difficulty is (0.5(unique operators) * total operators) / unique operators, and the effort is the difficulty * the volume.
>    The operands and operators were calculated through the variables from the Operand/Operator checks.

Tests: Each of these checks had simple tests, that confirmed their implimented getAcceptableTokens(), getRequiredTokens(), and getDefaultTokens() all returned their Token arrays ({0}) as expected. They also had various finishTree() and getMethod() tests that evaluated if mock values calculated correctly, and were updated correctly.



**Deliverable 2:**

Test results:
   70/70 tests ran, completed, and came back positive/without failure or error.

Explanation of Incomplete Coverage:

  I am not entirely certain what I did on eclipse, my POM.xml file matches the one given, and the DetailAST class is 
  able to be mocked, but I was unable to mock any of my Checks. Every time, I would get an error such as: 
  
>  [ERROR] Errors: 
>  [ERROR]   CommentLineCountTest.testFinishTree:140 Mockito 
>  Mockito cannot mock this class: class CatACheckPackage.CommentLineCountCheck.

  I assume this is because these classes are abstract, although I am uncertain, because in theory they should work.
  
  I threw a comment on each of the checks at the top explaining this; because of this inability to mock the classes, I was unable to get coverage of the visitToken, beginTree, and finishTree methods. I did however run through each if/else branches on the visitToken methods, and ran checks for the expected values of everything within those tests. So the tool doesn't show coverage of that, and I am unable to verify that the values logged are equivalent, but the values themselves are correct on their own.

CommentCountCheck
  Overall coverage: 52.8%
  Line coverage: 53.8%
  Branch coverage: 0/0 branches covered

CommentLineCountCheck
  Overall coverage: 33.7%
  Line coverage: 33.3%
  Branch coverage: 3t 3f/3 branches covered

ExpressionCountCheck
  Overall coverage: 47.3%
  Line coverage: 33.3%
  Branch coverage: 1t 1f/1 branches covered
  
LoopCountCheck
  Overall coverage: 55.6%
  Line coverage: 41.7%
  Branch coverage: 0/0 branches covered

OperandCountCheck
  Overall coverage: 40.1%
  Line coverage: 41.9%
  Branch coverage: 2t 2f/2 branches covered

OperatorCountCheck
  Overall coverage: 78.3%
  Line coverage: 46.7%
  Branch coverage: 3t 3f/3 branches covered

HalsteadLengthCheck
  Overall coverage: 61.8%
  Line coverage: 71.4%
  Branch coverage: 0/0 branches covered

HalsteadVocabularyCheck
  Overall coverage: 61.8%
  Line coverage: 71.4%
  Branch coverage: 0/0 branches covered

HalsteadDifficultyCheck
  Overall coverage: 67.5%
  Line coverage: 71.4%
  Branch coverage: 0/0 branches covered

HalsteadEffortCheck
  Overall coverage: 60.6%
  Line coverage: 71.4%
  Branch coverage: 0/0 branches covered

HalsteadVolumeCheck
  Overall coverage: 69.8%
  Line coverage: 71.4%
  Branch coverage: 0/0 branches covered
