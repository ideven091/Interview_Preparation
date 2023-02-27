# This is an input class. Do not edit.
class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None


def getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo):
    # Write your code here.
    depth1 = getDepth(topAncestor,descendantOne)
    depth2 = getDepth(topAncestor,descendantTwo)
    if depth1<depth2:
        diff = depth2-depth1
        return getAncestor(topAncestor,descendantOne,descendantTwo,diff)
    else:
        return getAncestor(topAncestor,descendantTwo,descendantOne,depth1-depth2)


def getDepth(topAncestor,descendant):
    depth = 0
    while descendant!=topAncestor:
        descendant=descendant.ancestor
        depth+=1
    return depth

def getAncestor(topAncestor,higher,lower,diff):
    while diff>0:
        lower=lower.ancestor
        diff-=1
    while higher!=lower and higher!=topAncestor:
        higher=higher.ancestor
        lower=lower.ancestor
    return higher
