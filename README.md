Test results:
  70/70 tests ran, completed, and came back positive/without failure or error.

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
