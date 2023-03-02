def getNthFib(n):
    # Write your code here.
    if n ==0 or n==1:
        return 0
    a = 0
    b = 1
    for i in range(1,n-1):
        b = a+b
        a = b-a
    return b

class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 1:
            return s
        #dp = [0 for _ in range(n)]
        #current_length=0;max_length=0
        longest=""
        low=0;high=n-1
        #"abad"->a..b..a
        #counter=1
        while low<high:
            if self.isPalindrome(s,low,high):
                return s[low:high+1]
            if s[low+1]==s[high]:
                low+=1
            elif s[low]==s[high-1]:
                high-=1
            else:
                low+=1;high-=1
        return s[0]

    def isPalindrome(self,s, low, high):
        mid = low + (high - low) // 2
        while low < mid:
            if s[low] != s[high]:
                return False
            low += 1;
            high -= 1
        return True
    def longestPalindromeV2(self, s: str) -> str:

        n = len(s)
        if n == 0:
            return ""
        start=0;end=0
        for i in range(n):
            l1 = self._expandAroundCenter(s,i,i)
            l2 = self._expandAroundCenter(s,i,i+1)
            length = max(l1,l2)
            if length>(end-start):
                start=i-(length-1)//2
                end = i+length//2
        return s[start:end+1]

    def _expandAroundCenter(self,s,low,high):
        LEFT = low;RIGHT=high
        while LEFT>=0 and RIGHT<len(s) and s[LEFT]==s[RIGHT]:
            LEFT-=1
            RIGHT+=1
        return RIGHT-LEFT-1



#getNthFib(2)
print(getNthFib(2))
print(Solution().longestPalindrome("abcbab"))
