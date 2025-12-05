An organized document/report detailed the test cases, test
results, and coverage percentage.
➢ For each Check class, identify the percentage of lines/branches that are
covered. You may simply use Eclipse built-in coverage tool for line
coverage; and you might want to count the branch coverage. (e.g.
22/24 lines covered, 4t 3f/4 branches covered – once again, remember
branch coverage requires you to test both True and False)
✓ Note that the Eclipse built-in coverage tool computes “branch
coverage” in a slightly different way (it’s actually conditional
coverage)
✓ So, when you are using the tool, count the “branch coverage” by
yourselves, as your percentage is likely higher or equal to what the
tool will show 6
An organized document/report detailed the test cases, test
results, and coverage percentage. (cont.)

Explanation of Incomplete Coverage:

  I am not entirely certain what I did on eclipse, my POM.xml file matches the one given, and the DetailAST class is 
  able to be mocked, but I was unable to mock any of my Checks. Every time, I would get an error such as: 
  
  [ERROR] Errors: 
  [ERROR]   CommentLineCountTest.testFinishTree:140 Mockito 
  Mockito cannot mock this class: class CatACheckPackage.CommentLineCountCheck.

  I assume this is because these classes are abstract, although I am uncertain, because in theory they should work.
  
  I threw a comment on each of the checks at the top explaining this; because of this inability to mock the classes, 
  I was unable to get coverage of the visitToken, beginTree, and finishTree methods. I did however run through each 
  if/else branches on the visitToken methods, and ran checks for the expected values of everything within those tests. 
  So the tool doesn't show coverage of that, and I am unable to verify that the values logged are equivalent, but the 
  values themselves are correct on their own.

CommentCountCheck
  Line coverage: 52.8%
  Branch coverage: 

CommentLineCountCheck
  Line coverage: 52.8%
  Branch coverage: 

ExpressionCountCheck
  Line coverage: 52.8%
  Branch coverage: 
  
LoopCountCheck
  Line coverage: 52.8%
  Branch coverage: 

OperandCountCheck
  Line coverage: 52.8%
  Branch coverage: 

OperatorCountCheck
  Line coverage: 52.8%
  Branch coverage: 

HalsteadLengthCheck
  Line coverage: 61.8%
  Branch coverage: 

HalsteadVocabularyCheck
  Line coverage: 61.8%
  Branch coverage: 

HalsteadDifficultyCheck
  Line coverage: 67.5%
  Branch coverage: 

HalsteadEffortCheck
  Line coverage: 60.6%
  Branch coverage: 

HalsteadVolumeCheck
  Line coverage: 69.8%
  Branch coverage: 
