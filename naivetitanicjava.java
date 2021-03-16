import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner ab = new Scanner(System.in);
	    
	    //Col 1= rich/poor, Col 2= young/old, Col 3= m/f Col 4=1/2 floor, Col 5= Saved yes/no
	    String [][] people= {
	        {"rich", "young", "m" ,"1", "no"},
	        {"rich", "young", "f" ,"2", "no"},
	        {"rich", "old", "m" , "2", "yes"},
	        {"rich", "old", "f", "1", "yes"},
	        {"rich", "old", "f","2", "yes"},
	        {"rich" ,"old","m","2" ,"no"},
	        {"poor", "young", "m" , "1", "no"},
	        {"poor", "old", "m" ,"1","yes"},
	        {"poor", "young", "f", "1","yes"},
	        {"poor", "old", "f", "2", "yes"},
	        {"poor" , "old" , "m" , "2" , "no"},
	        {"rich", "young", "f", "1","no"},
	        {"poor", "old", "f", "1", "yes"},
	        {"poor" , "old" , "m" , "2" , "yes"},
	        {"rich", "young", "f", "1","no"},
	        {"poor", "young", "f", "2", "no"},
	        {"poor" , "young" , "m" , "2" , "no"},
	        {"poor", "old", "f", "2","yes"},
	        {"rich", "old", "f", "1", "yes"},
	        {"poor" , "old" , "m" , "2" , "no"}
	    };
	    double y=0, n=0;
	    double c1y=0,c2y=0,c3y=0,c4y=0, c1n=0,c2n=0,c3n=0,c4n=0;
	    double c1=0, c2=0, c3=0, c4=0;
	    double pl = people.length;
	    //c1y = rich when yes
	    //c2y = young when yes
	    //c3y = m when yes
	    //c4y = '1' when yes
	    //c1n = rich when no
	    //c2n = young when no
	    //c3n = m when no
	    //c4n = '1' when no
	    //c1 = rich all
	    //c2 = young all
	    //c3 = m all
	    //c4 = '1' all
	    for(int i=0; i<pl; i++)
	    {
	        if(people[i][4]=="yes")
	        {
	            y++;
	            if(people[i][0]=="rich")
	            {
	                c1y++;
	            }
	            if(people[i][1]=="young")
	            {
	                c2y++;
	            }
	            if(people[i][2]=="m")
	            {
	                c3y++;
	            }
	            if(people[i][3]=="1")
	            {
	                c4y++;
	            }
	        }
	        else
	        {
	            n++;
	            if(people[i][0]=="rich")
	            {
	                c1n++;
	            }
	            if(people[i][1]=="young")
	            {
	                c2n++;
	            }
	            if(people[i][2]=="m")
	            {
	                c3n++;
	            }
	            if(people[i][3]=="1")
	            {
	                c4n++;
	            }
	        }
	        if(people[i][0]=="rich")
	            {
	                c1++;
	            }
	        if(people[i][1]=="young")
	            {
	                c2++;
	            }
            if(people[i][2]=="m")
	            {
	                c3++;
	            }
            if(people[i][3]=="1")
	            {
	                c4++;
	            }
	        
	    }
        /*
        p(n) = (n/(pl))
        p(y) = (y/(pl))
        
        p(rich) = (c1/pl)
        p(poor) = ((pl-c1)/pl)
        p(young) = (c2/pl)
        p(old) = ((pl-c2)/pl)
        p(m) = (c3/pl)
        p(f) = ((pl-c3)/pl)
        p(1) = (c4/pl)
        p(2) = ((pl-c4)/pl)
        
        p(rich/y) = (c1y/y)
        p(poor/y) = ((y-c1y)/y)
        p(rich/n) = (c1n/n)
        p(poor/n) = ((n-c1n)/n)
         
        p(young/y) = (c2y/y)
        p(old/y) = ((y-c2y)/y)
        p(young/n) = (c2n/n)
        p(old/n) = ((n-c2n)/n)
        
        p(m/y) = (c3y/y)
        p(f/y) = ((y-c3y)/y)
        p(m/n) = (c3n/n)
        p(f/n) = ((n-c3n)/n)
        
        p(1/y) = (c4y/y)
        p(2/y) = ((y-c4y)/y)
        p(1/n) = (c4n/n)
        p(2/n) = ((n-c4n)/n)
        */
        
    
    System.out.println("        Titanic Dataset \n");
    System.out.println("  Economy  Age  Gender Floor Saved \n");
    for(int q=0; q<pl; q++)
    {
        for(int m=0;m<5;m++)
        {
            System.out.print("  " + people[q][m]+"  ");
        }
        System.out.println("\n");
        
    }
        
        
    //============ Unseen Data ==================
        
        
        System.out.println("Enter description of person to be saved");
        
        double save = (y/(pl));
        double notsave = (n/(pl));
        
        System.out.println("Enter 'rich' or 'poor'");
        String rp = ab.nextLine();
        if(rp.equals("rich"))
        {
           save = save * (c1y/y) / (c1/pl);
           notsave = notsave * (c1n/n) / (c1/pl);
        }
        else
        {
            save = save * ((y-c1y)/y) / ((pl-c1)/pl);
            notsave = notsave * ((n-c1n)/n) / ((pl-c1)/pl);
        }
        
        
        System.out.println("Enter 'young' or 'old'");
        String yo = ab.nextLine();
        if(yo.equals("young"))
        {
           save = save * (c2y/y) / (c2/pl);
           notsave = notsave * (c2n/n) / (c2/pl);
        }
        else
        {
            save = save * ((y-c2y)/y) / ((pl-c2)/pl);
            notsave = notsave * ((n-c2n)/n) / ((pl-c2)/pl);
        }
        
        
        System.out.println("Enter male-'m' or female-'f'");
        String mf = ab.nextLine();
        if(mf.equals("m"))
        {
           save = save * (c3y/y) / (c3/pl);
           notsave = notsave * (c3n/n) / (c3/pl);
        }
        else
        {
            save = save * ((y-c3y)/y) / ((pl-c3)/pl);
            notsave = notsave * ((n-c3n)/n) / ((pl-c3)/pl);
        }
        
        System.out.println("Enter floor number '1' or '2'");
        String ot = ab.nextLine();
        if(ot.equals("1"))
        {
           save = save * (c4y/y) / (c4/pl);
           notsave = notsave * (c4n/n) / (c4/pl);
        }
        else
        {
            save = save * ((y-c4y)/y) / ((pl-c4)/pl);
            notsave = notsave * ((n-c4n)/n) / ((pl-c4)/pl);
        }
        
        
        
        System.out.println("Probability of saving " + rp +", " + yo + ", " + mf + " on floor no. " + ot + " is " +save/(save+notsave)+"\n");
        
        
        
    //===========================================================
        
        
        
        
       /* 
       
        SELF EXAMPLES
       
       
        //to check rich, young , m, 1 and saved
        double rym1s = ((y/(pl))(c1y/y)(c2y/y)(c3y/y)(c4y/y) )/ ((c1/pl)(c2/pl)(c3/pl)*(c4/pl));
        
        //same but not save
        double rym1ns = ((n/(pl))(c1n/n)(c2n/n)(c3n/n)(c4n/n))/ ((c1/pl)(c2/pl)(c3/pl)*(c4/pl));
        
		System.out.println("probability of saving rich, young, male on 1st floor is " + rym1s/(rym1s+rym1ns));
		System.out.println("probability of not saving rich, young, male on 1nd floor is " + rym1ns/(rym1s+rym1ns));
		
		
		//poor old female, 1, no
		double pof1ns = ((n/(pl))((n-c1n)/n)((n-c2n)/n)((n-c3n)/n)(c4n/n) )/ (((pl-c1)/pl)((pl-c2)/pl)((pl-c3)/pl)*(c4/pl));
		
		//poor old female, 1, yes
		double pof1s = ((y/(pl))((y-c1y)/y)((y-c2y)/y)((y-c3y)/y)(c4y/y) )/ (((pl-c1)/pl)((pl-c2)/pl)((pl-c3)/pl)*(c4/pl));
		System.out.println("probability of saving poor old female, 1st floor is " + pof1s/(pof1s+pof1ns));
		System.out.println("probability of not saving poor old female, 1st floor is " + pof1ns/(pof1s+pof1ns));
	*/
	
	

    //============== Model Accuracy ===========================================================//
	
	
	String [] cmp = new String[(int)pl];
	
	double summ= 0;
	    
	    for(int i=0; i<pl; i++)
	    {
	        double save1 = (y/(pl));
            double notsave1 = (n/(pl));
            
            
	        if(people[i][0].equals("m"))
            {
               save1 = save1 * (c3y/y) / (c3/pl);
               notsave1 = notsave1 * (c3n/n) / (c3/pl);
            }
            else
            {
                save1 = save1 * ((y-c3y)/y) / ((pl-c3)/pl);
                notsave1 = notsave1 * ((n-c3n)/n) / ((pl-c3)/pl);
            }
            
            if(people[i][1].equals("young"))
            {
               save1 = save1 * (c2y/y) / (c2/pl);
               notsave1 = notsave1 * (c2n/n) / (c2/pl);
            }
            else
            {
                save1 = save1 * ((y-c2y)/y) / ((pl-c2)/pl);
                notsave1 = notsave1 * ((n-c2n)/n) / ((pl-c2)/pl);
            }
            
            
            if(people[i][2].equals("m"))
            {
               save1 = save1 * (c3y/y) / (c3/pl);
               notsave1 = notsave1 * (c3n/n) / (c3/pl);
            }
            else
            {
                save1 = save1 * ((y-c3y)/y) / ((pl-c3)/pl);
                notsave1 = notsave1 * ((n-c3n)/n) / ((pl-c3)/pl);
            }
	        
	        if(people[i][3].equals("1"))
            {
               save1 = save1 * (c4y/y) / (c4/pl);
               notsave1 = notsave1 * (c4n/n) / (c4/pl);
            }
            else
            {
                save1 = save1 * ((y-c4y)/y) / ((pl-c4)/pl);
                notsave1 = notsave1 * ((n-c4n)/n) / ((pl-c4)/pl);
            }
            
            
            
            double prob = save1/(save1+notsave1);
            if(prob>0.5)
            {
                cmp[i]= "yes";
                //cmp.add("yes");
            }
            else{
                cmp[i]="no";
                //cmp.add("no");
            }
            

        
	
	    }
	    double acc=0;
	    for(int j=0; j<pl; j++)
	    {
	       if(cmp[j]==people[j][4])
	       {
	           acc+=1;
	       }
	    }
	    System.out.println("Model accuracy is " + (acc/pl*100) +"%");
	    
	    
	    //=========================================================================================
	    


	    
	}
}