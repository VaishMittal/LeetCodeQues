class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String st : tokens){
            if(st.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(st.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(st.equals("-")){
                int a = stack.pop(),b=stack.pop();
                stack.push(b-a);
            }
            else if(st.equals("/")){
                int a = stack.pop(),b=stack.pop();
                stack.push(b/a);
            }
            else{
                
                stack.push(Integer.parseInt(st));
            }
        }
        return stack.pop();
    }
}


