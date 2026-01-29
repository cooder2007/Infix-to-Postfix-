def priority(op):
    if op == '^':
        return 3
    if op == '*' or op == '/' or op == '%':
        return 2
    if op == '+' or op == '-':
        return 1
    return 0

stack = []
postfix = ""

infix = input("Enter infix expression: ")

for ch in infix:

    if ch.isalnum():
        postfix += ch

    elif ch == '(':
        stack.append(ch)

    elif ch == ')':
        while stack and stack[-1] != '(':
            postfix += stack.pop()
        stack.pop()

    else:
        while stack and priority(stack[-1]) >= priority(ch):
            postfix += stack.pop()
        stack.append(ch)

while stack:
    postfix += stack.pop()

print("Postfix expression:", postfix)
