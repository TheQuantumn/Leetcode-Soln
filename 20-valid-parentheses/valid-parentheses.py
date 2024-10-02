class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False
        
        bracket_map = {'(': ')', '[': ']', '{': '}'}
        stack = []
        
        for char in s:
            if char in bracket_map:
                stack.append(char)
            else:
                if not stack:
                    return False
                top_element = stack.pop()
                if char != bracket_map[top_element]:
                    return False
        
        return not stack
