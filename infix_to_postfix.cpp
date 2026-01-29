// This Program is to Convert Infix Expression to Postfix Expression using Stack Data Structure in C++
#include <iostream>
#include<string>
#include <stack>
using namespace std;

int priority(char op) {
    if (op == '^')
        return 3;
    if (op == '*' || op == '/' || op == '%')
        return 2;
    if (op == '+' || op == '-')
        return 1;
    return 0;
}

int main() {
    string ifix, pfix = "";
    stack<char> st;

    cout << "Enter infix expression: ";
    cin >> ifix;

    for (int i = 0; i < ifix.length(); i++) {
        char ch = ifix[i];

        if (isalnum(ch)) {
            pfix += ch;
        }
        
        else if (ch == '(') {
            st.push(ch);
        }
        
        else if (ch == ')') {
            while (!st.empty() && st.top() != '(') {
                pfix += st.top();
                st.pop();
            }
            st.pop();
        }
        
        else {
            while (!st.empty() && priority(st.top()) >= priority(ch)) {
                pfix += st.top();
                st.pop();
            }
            st.push(ch);
        }
    }

    while (!st.empty()) {
        pfix += st.top();
        st.pop();
    }

    cout << "Postfix expression: " << pfix << endl;

    return 0;
}
