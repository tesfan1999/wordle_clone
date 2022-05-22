import java.util.*;
import java.net.*;
class wordle
{
   HashMap<Character, Integer> map ;//hashmap for word count
    public void count_word(String s)
   {
       map = new HashMap<Character, Integer>(); //initializing hashmap
       for (int i = 0; i < s.length(); i++) 
       {
           
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) 
            {
                    map.put(c, new Integer(val + 1));//word count
            }
            else 
            {
               map.put(c, 1);
            }
       }
   }
    public boolean is_alphabet(String st)
   {
       int l=st.length();
       for(int i=0;i<l;i++)
       {
           char ch=st.charAt(i);
           if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
           {
               continue;
           }
           else
               return false;
       }
       return true;
   }
   public String inni ()//input from user
   {
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a five letter word");
            String st=sc.nextLine();
            boolean b=is_alphabet(st);
            if(st.length()==5 && b==true)//check if length is 5
            {
                st=st.toLowerCase();
                return st;
            }
            else
            {
                System.out.println("Invalid Input....Please Enter a valid five letter word");
                continue;
            }
        }
   }
    public static void main(String args[])throws Exception
    {
        Scanner s;
        wordle ob=new wordle();
        URL url = new URL("https://raw.githubusercontent.com/charlesreid1/five-letter-words/master/sgb-words.txt");//fetching wordlist
        s = new Scanner(url.openStream());
        ArrayList<String> ar = new ArrayList<String>();//arraylist to store words
        int i=0;
        while(s.hasNextLine())
        {
            //System.out.println(s.nextLine());
            
            try
            {    
                String st=s.nextLine();
                ar.add(st);//storing words from url into arraylist
                i++;
            }
            catch(Exception e)
            {
                continue;
            }
        }
        System.out.println("oooooo   oooooo     oooo                          .o8  oooo  ");
        System.out.println(" `888.    `888.     .8'                           `888  888  ");
        System.out.println("  `888.   .8888.   .8'    .ooooo.  oooo d8b  .oooo888   888   .ooooo.");
        System.out.println("   `888  .8'`888. .8'    d88' `88b `888``8P d88' `888   888  d88' `88b ");
        System.out.println("    `888.8'  `888.8'     888   888  888     888   888   888  888ooo888");
        System.out.println("     `888'    `888'      888   888  888     888   888   888  888    .o");
        System.out.println("      `8'      `8'       `Y8bod8P' d888b    `Y8bod88P` o888o `Y8bod8P'");//ascii art to look applealing
        int h=0;
        Scanner sc=new Scanner(System.in);
        while(h==0)
        {
            int time=1;//to store the amount of attempts the user made
            String st="";// to store the string given by the user
            System.out.println("\n\n1.Play");//menu
            System.out.println("2.Rules");
            System.out.println("3.Exit");
            int cho=sc.nextInt();
            sc.nextLine();
            switch(cho)
            {
                case 1:
                {
                    
                    double t=(Math.random()*1000)%ar.size();//generating random value
                    int in=(int)t;
                    String w=ar.get(in);//assigning a word based on random value
                    st=ob.inni();
                    String insen="";//variable to store words in the sentence
                    String nosen="";//variable to store words not in the sentence
                    int flag=0;
                    ob.count_word(w);//count words and map them
                    
                    while(true)
                    {
                        String st1="";
                        String ga="";//to store index of the user word after comparing it with the random word  
                        System.out.println("\nTry:"+time);
                        if(st.equals(w))//user string equals random string
                        {
                            flag=1;
                            break;
                        }
                        int f=0;
                        int f1=0;
                        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();//hash map to count and map user string
                        Integer val=0;
                        Integer val2=0;
                        for(int x=0;x<st.length();x++)
                        {
                            char ch=st.charAt(x);
                            val = mp.get(ch);//count of the particular character in user string
                            val2=ob.map.get(ch);//count of the particular character in random string
                            if(w.charAt(x)==ch)//if character is found at that particular location
                            {
                                
                                if (val != null) 
                                {
                                        mp.put(ch, new Integer(val + 1));
                                }
                                 else 
                                {
                                   mp.put(ch, 1);
                                }
                                val = mp.get(ch);
                                if(val!=null && val<=val2)//add + if the count is less or equal to original's
                                {
                                    ga=ga+"+"+" ";
                                }
                                else//if count is more add - to a previous occurence of the word
                                {
                                    System.out.println("Works");
                                    ga=ga+"+"+" ";
                                    int ide=st.indexOf(ch);
                                    if(ide==0)//encountered a few problems with the first index so the condtional statements
                                    ga= ga.substring(0, ide) +"-"+" "+ga.substring(ide + 2);
                                    else
                                    ga= ga.substring(0, ide) +" "+"-"+ga.substring(ide + 2);
                                }
                                //System.out.println(""+w.charAt(x)+""+ch);
                                if(insen.indexOf(ch)==-1)
                                insen=insen+ch+" ";
                            }
                            else if(w.indexOf(ch)==-1)//if character is not found in the word
                            {
                                ga=ga+"-"+ " ";
                                if(nosen.indexOf(ch)==-1)
                                nosen=nosen+ch+" ";
                            }
                            else if(w.indexOf(ch)!=-1)//if the character is found in the word but in a different index 
                            {
                                if (val != null) 
                                {
                                        mp.put(ch, new Integer(val + 1));
                                }
                                 else 
                                {
                                   mp.put(ch, 1);
                                }
                                val = mp.get(ch);
                                if(val!=null && val<=val2)//if count is less than equal to original
                                {
                                    ga=ga+"o"+" ";
                                }
                                else
                                {
                                    ga=ga+"-"+" ";
                                }
                                if(insen.indexOf(ch)==-1)
                                insen=insen+ch+" ";
                            }
                            st1=st1+ch+" ";//add spaces to the original character for better readability
                        }
                        //print the output
                        System.out.println("\n"+st1);
                        System.out.println(ga);
                        System.out.println("\nLetters in the word:\n"+insen);
                        System.out.println("\nLetters not in the word:\n"+nosen);
                        time++;
                        if(time>=7)//break if the number of tries is up
                        {
                            break;
                        }
                        st=ob.inni();
                    }
                    if(flag==1)//winner condition
                    {
                        System.out.println("\nCongratulations , You Win\n");
                        System.out.println("'  oooo     oooo ooooo oooo   oooo oooo   oooo ooooooooooo oooooooooo ");
                        System.out.println("'   88   88  88   888   8888o  88   8888o  88   888         888    888");
                        System.out.println("'    88 888 88    888   88 888o88   88 888o88   888ooo888   888oooo88");
                        System.out.println("'     888 888     888   88   8888   88   8888   888         888  88o");
                        System.out.println("'      8   8     o888o o88o    88  o88o    88  o888ooo8888 o888o  88o8");
                    }
                    else
                    {
                        System.out.println("Sorry,You lose!!");
                        System.out.println("\nThe Word Was:\n"+w);
                    }
                }
                break;
                case 2://rules of the game  
                {
                    System.out.println("\nWELCOME TO WORDLE!!!");
                    System.out.println("\nEnter a 5 letter word and see if it matches our randomly chosen word \n"); 
                    System.out.println("Rules: \n+ means letter is in correct position \n- means letter doesn't exist in word \no mean letter exists but different position");
                    System.out.println("You get 6 tries!!!!");
                    System.out.println("Good Luck!!!");
                }
                break;
                case 3://exit
                    h=1;
                    break;
                default:
                     System.out.println("Invalid Input");
            
            }
       }
   }
}
