class Solution{
    public boolean halvesAreAlike(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=Character.toLowerCase(s.charAt(i));
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                c+= i < s.length()/2 ? 1 : -1;
        }
        return c==0;
    }
}
