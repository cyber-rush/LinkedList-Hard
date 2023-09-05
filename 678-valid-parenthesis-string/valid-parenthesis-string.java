class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack();
        Stack<Integer> star = new Stack();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '*'){
                star.push(i);
            }
            else if(s.charAt(i) == '('){
                open.push(i);
            }
            else{
                if(open.size() > 0){
                    open.pop();
                }
                else if(star.size() > 0){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        while(open.size() > 0){
            if(star.size() == 0 ){
                return false;
            }
            else if(open.peek() < star.peek()){
                open.pop();
                star.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}