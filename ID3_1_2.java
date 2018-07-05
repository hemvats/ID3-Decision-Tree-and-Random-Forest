import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ID3_1_2
{
	static ArrayList <Integer []> TrainingData = new ArrayList <Integer[]> ();
    static ArrayList <Integer []> TestData = new ArrayList <Integer[]> ();
    static Noode_2 root;
    static Noode_2 root_2;
    static double amax;
    static int ct;
	//static Integer arr[] = new Integer[15];
	public static String[] strWorkClass = {" Private", " Self-emp-not-inc", " Self-emp-inc", " Federal-gov", " Local-gov", " State-gov", " Without-pay", " Never-worked"};
	public static String[] strEducation = {" Bachelors", " Some-college", " 11th", " HS-grad", " Prof-school", " Assoc-acdm", " Assoc-voc", " 9th", " 7th-8th", " 12th", " Masters", " 1st-4th", " 10th", " Doctorate", " 5th-6th", " Preschool"};
	public static String[] strMartial = {" Married-civ-spouse", " Divorced", " Never-married", " Separated", " Widowed"," Married-spouse-absent", " Married-AF-spouse"};
	public static String[] strOccupation = {" Tech-support", " Craft-repair", " Other-service", " Sales", " Exec-managerial", " Prof-specialty", " Handlers-cleaners", " Machine-op-inspct", " Adm-clerical", " Farming-fishing", " Transport-moving", " Priv-house-serv"," Protective-serv", " Armed-Forces"};
	public static String[] strRelationship = {" Wife", " Own-child", " Husband", " Not-in-family", " Other-relative", " Unmarried"};
	public static String[] strRace = {" White", " Asian-Pac-Islander", " Amer-Indian-Eskimo", " Other", " Black"};
	public static String[] strSex = {" Female", " Male"};
	public static String[] strCountry = {" United-States", " Cambodia", " England", " Puerto-Rico", " Canada", " Germany", " Outlying-US(Guam-USVI-etc)", " India", " Japan", " Greece", " South", " China", " Cuba", " Iran", " Honduras", " Philippines", " Italy", " Poland", " Jamaica", " Vietnam", " Mexico", " Portugal", " Ireland", " France", " Dominican-Republic", " Laos", " Ecuador", " Taiwan", " Haiti", " Columbia", " Hungary", " Guatemala", " Nicaragua", " Scotland", " Thailand", " Yugoslavia", " El-Salvador", " Trinadad&Tobago", " Peru", " Hong", " Holand-Netherlands"};
	
    public static String[] strAttr = {"age","work","fnl","ed","ednum","mar","ocp","rel","race","sex","capgain","caploss","hrspw","cntry"};

    public static Integer[] count = {4,8,2,16,2,7,14,6,5,2,2,2,2,41};


    public static void main (String args[])
	{
		String FileLoc = "/home/hemvats/Desktop/ML_assns/ML_assn2_7/ID3_1data1.txt";
		BufferedReader br = null;
		String line,s;
		String lineVector[];
		Integer i,j,k,flag,n,l;	
		Integer [] arr;
        ID3_1_2 obj = new ID3_1_2();
        ct=0;
		//int ct=1;
		try
		{
			br = new BufferedReader(new FileReader(FileLoc));
			while((line = br.readLine())!=null)
			{
				lineVector = line.split(",");
				if(lineVector.length==(15))
				{
					arr = new Integer[15];

					//int ct=1;
					//try{
					//for last attr
					if(lineVector[14].equals(" >50K"))arr[14]=1;
					else arr[14]=0;

					//for first attr
					if(lineVector[0].equals(" ?")) arr[0]=-1;
					else if(Integer.parseInt(lineVector[0].trim())<=30) arr[0]=0;
					else if(Integer.parseInt(lineVector[0].trim())<=45) arr[0]=1;
					else if(Integer.parseInt(lineVector[0].trim())<=60) arr[0]=2;
					else arr[0]=3;

					//for 2nd attr
					flag=0;
					for (i=0;i<strWorkClass.length;i++)
					{
						if(lineVector[1].equals(strWorkClass[i]))
						{
							arr[1]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[1]=-1;

					//for 3rd attr
					//if(lineVector[2].equals(" ?")) arr.fnl=-1;
					//try
					//{
						if(lineVector[2].equals(" ?")) arr[2]=-1;	
						else if(Integer.parseInt(lineVector[2].trim())<=60000) arr[2]=0;
						else arr[2]=1;
					//}
					//catch (NumberFormatException ex){arr.fnl=1;}
					

					//for 4th attr
					flag=0;
					for (i=0;i<strEducation.length;i++)
					{
						if(lineVector[3].equals(strEducation[i]))
						{
							arr[3]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[3]=-1;

					//for 5th attr
					if(lineVector[4].equals(" ?")) arr[4]=-1;
					else if(Integer.parseInt(lineVector[4].trim())<=8) arr[4]=0;
					else arr[4]=1;

					//for 6th attr
					flag=0;
					for (i=0;i<strMartial.length;i++)
					{
						if(lineVector[5].equals(strMartial[i]))
						{
							arr[5]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[5]=-1;

					//for 7th attr
					flag=0;
					for (i=0;i<strOccupation.length;i++)
					{
						if(lineVector[1].equals(strOccupation[i]))
						{
							arr[6]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[6]=-1;

					//for 8th attr
					flag=0;
					for (i=0;i<strRelationship.length;i++)
					{
						if(lineVector[7].equals(strRelationship[i]))
						{
							arr[7]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[7]=-1;

					//for 9th attr
					flag=0;
					for (i=0;i<strRace.length;i++)
					{
						if(lineVector[8].equals(strRace[i]))
						{
							arr[8]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[8]=-1;

					//for 10th attr
					flag=0;
					for (i=0;i<strSex.length;i++)
					{
						if(lineVector[9].equals(strSex[i]))
						{
							arr[9]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[9]=-1;

					//for 11th attr;
					if(lineVector[10].equals(" ?")) arr[10]=-1;
					else if(Integer.parseInt(lineVector[10].trim())<=10000) arr[10]=0;
					else arr[10]=1;

					//for 12th attr
					if(lineVector[11].equals(" ?")) arr[11]=-1;
					else if(Integer.parseInt(lineVector[11].trim())<=2000) arr[11]=0;
					else arr[11]=1;

					//for 13th attr
					if(lineVector[12].equals(" ?")) arr[12]=-1;
					else if(Integer.parseInt(lineVector[12].trim())<=47) arr[12]=0;
					else arr[12]=1;

					//for 14th attr
					flag=0;
					for (i=0;i<strCountry.length;i++)
					{
						if(lineVector[13].equals(strCountry[i]))
						{
							arr[13]=i;
							flag=1;
							break;
						}
					}
					if(flag==0) arr[13]=-1;
					//}
					//catch (NumberFormatException ex) {System.out.println("\nexception occured beta "+ ct); ct=ct+1;}
					TrainingData.add(arr);
					//TrainingData.add(arr);
				}
			}
		}
		catch (FileNotFoundException e)
			{e.printStackTrace();}
		catch(IOException e)
			{e.printStackTrace();}
		finally 
		{
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }

        //Assigning value to missing attrs
        int cnt []; k=0;

        //for 2nd attr
        n=strWorkClass.length; j=0; 
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0; 
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[1]!=-1)
       		{
       			cnt[arr[1]] = cnt[arr[1]]+1;
       			if(cnt[arr[1]]>j)
       			{
       				j=cnt[arr[1]];
       				k=arr[1];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[1]==-1)
       		{
       			arr[1]=k;	
       		}
        }

        //for 1st attr
        n=4; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[0]!=-1)
       		{
       			cnt[arr[0]] = cnt[arr[0]]+1;
       			if(cnt[arr[0]]>j)
       			{
       				j=cnt[arr[0]];
       				k=arr[0];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[0]==-1)
       		{
       			arr[0]=k;	
       		}
        }

        //for 3rd attr
        n=2; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[2]!=-1)
       		{
       			cnt[arr[2]] = cnt[arr[2]]+1;
       			if(cnt[arr[2]]>j)
       			{
       				j=cnt[arr[2]];
       				k=arr[2];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[1]==-1)
       		{
       			arr[2]=k;	
       		}
        }

        //for 4th attr
        n=strEducation.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[3]!=-1)
       		{
       			cnt[arr[3]] = cnt[arr[3]]+1;
       			if(cnt[arr[3]]>j)
       			{
       				j=cnt[arr[3]];
       				k=arr[3];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[3]==-1)
       		{
       			arr[3]=k;	
       		}
        }

        //for 5th attr
        n=2; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[4]!=-1)
       		{
       			cnt[arr[4]] = cnt[arr[4]]+1;
       			if(cnt[arr[4]]>j)
       			{
       				j=cnt[arr[4]];
       				k=arr[4];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[4]==-1)
       		{
       			arr[4]=k;	
       		}
        }

        //for 6th attr
        n=strMartial.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[5]!=-1)
       		{
       			cnt[arr[5]] = cnt[arr[5]]+1;
       			if(cnt[arr[5]]>j)
       			{
       				j=cnt[arr[5]];
       				k=arr[5];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[5]==-1)
       		{
       			arr[5]=k;	
       		}
        }

        //for 7th attr
        n=strOccupation.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[6]!=-1)
       		{
       			cnt[arr[6]] = cnt[arr[6]]+1;
       			if(cnt[arr[6]]>j)
       			{
       				j=cnt[arr[6]];
       				k=arr[6];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[6]==-1)
       		{
       			arr[6]=k;	
       		}
        }

        //for 8th attr
        n=strRelationship.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[7]!=-1)
       		{
       			cnt[arr[7]] = cnt[arr[7]]+1;
       			if(cnt[arr[7]]>j)
       			{
       				j=cnt[arr[7]];
       				k=arr[7];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[7]==-1)
       		{
       			arr[7]=k;	
       		}
        }

        //for 9th attr
        n=strRace.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[8]!=-1)
       		{
       			cnt[arr[8]] = cnt[arr[8]]+1;
       			if(cnt[arr[8]]>j)
       			{
       				j=cnt[arr[8]];
       				k=arr[8];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[8]==-1)
       		{
       			arr[8]=k;	
       		}
        }

        //for 10th attr
        n=strSex.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[9]!=-1)
       		{
       			cnt[arr[9]] = cnt[arr[9]]+1;
       			if(cnt[arr[9]]>j)
       			{
       				j=cnt[arr[9]];
       				k=arr[9];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[9]==-1)
       		{
       			arr[9]=k;	
       		}
        }

        //for 11th attr
        n=2; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[10]!=-1)
       		{
       			cnt[arr[10]] = cnt[arr[10]]+1;
       			if(cnt[arr[10]]>j)
       			{
       				j=cnt[arr[10]];
       				k=arr[10];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[10]==-1)
       		{
       			arr[10]=k;	
       		}
        }

        //for 12th attr
        n=2; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[11]!=-1)
       		{
       			cnt[arr[11]] = cnt[arr[11]]+1;
       			if(cnt[arr[11]]>j)
       			{
       				j=cnt[arr[11]];
       				k=arr[11];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[11]==-1)
       		{
       			arr[11]=k;	
       		}
        }

        //for 13th attr
        n=2; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[12]!=-1)
       		{
       			cnt[arr[12]] = cnt[arr[12]]+1;
       			if(cnt[arr[12]]>j)
       			{
       				j=cnt[arr[12]];
       				k=arr[12];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[12]==-1)
       		{
       			arr[12]=k;	
       		}
        }

        //for 14th attr
        n=strCountry.length; j=0;
        cnt = new int [n];
       	for (i=0;i<n;i++) cnt[i]=0;
       	for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[13]!=-1)
       		{
       			cnt[arr[13]] = cnt[arr[13]]+1;
       			if(cnt[arr[13]]>j)
       			{
       				j=cnt[arr[13]];
       				k=arr[13];
       			}
       		}
        }
        for (i=0;i<TrainingData.size();i++)
       	{
       		arr = TrainingData.get(i);
            if(arr[13]==-1)
       		{
       			arr[13]=k;	
       		}
        }
        
        /*for (i=0;i<TrainingData.size();i++)
        {
            arr = TrainingData.get(i);
            for (j=0;j<arr.length;j++)
            {
                System.out.println(arr[j]+"  ");
            }
            System.out.println("\n");
        }*/

        ///////////////////////////////////////////////
        k=0; j=0; l=0; 
        double d,h; d=0; h=0;
        for (i=0;i<14;i++)
        {
            d=entropyGain(TrainingData,i);
            if(d>h)
            {
                h=d;
                k=i;
            }
        }
        System.out.println(h+ " "+ k);

        Integer [] mark = new Integer [14];
        for (i=0;i<14;i++) mark[i]=0;
        root = new Noode_2(k, TrainingData, mark);

        //making tree
        //System.out.println(root.Tdata.size());
        obj.makeTree(root);        
        
        testData();

        Integer [] mark_2 = new Integer [14];
        for (i=0;i<14;i++) mark_2[i]=0;
        root_2 = new Noode_2(k, TrainingData, mark_2);

        //making tree
        //System.out.println(root.Tdata.size());
        obj.makeTree(root_2);
        pruneTree();

        System.out.println(amax);

        int hei=findHeight(root);
        System.out.println(hei);

        hei=findHeight(root_2);
        System.out.println(hei);

        System.out.println();
        treeTraversal(root);

        System.out.println();
        treeTraversal(root_2);



        //for (j=0;j<14;j++) System.out.print(root.marrk[j]+ "  ");
        //////////////////////////////////////////////
	}

    /// brought methods from there

    public void makeTree(Noode_2 noode)
    {
        int i,j,k;
        double m,n,l; 
        Integer [] arr;
        n=noode.marrk.length;
           
        //System.out.println(noode.id);
        /*k=0;
        for (i=0;i<n;i++)
        {
            if(noode.marrk[i]==0)
            {
                k=1;
                break;
            }
        }
        if(k==0) return;*/
        
        if((noode.leaf==1) || (noode.Tdata.size()==0)) 
        {
            //
            return;
        }

        //System.out.println("This is id"+noode.id);
        //System.out.println(count[noode.id]);

        for (i=0;i<count[noode.id];i++)
        {
            ArrayList <Integer []> pass = new ArrayList <Integer []>();
            //System.out.println("This is id"+noode.id);
            //System.out.println(count[noode.id]);
            //System.out.println(noode.id);
            for (j=0;j<noode.Tdata.size();j++)
            {
                //Class<?> the = Trdata.get(j).getClass();
                //Field fthe = the.getField(strAttr[noode.id]);
                //if((int)fthe.get(Trdata.get(j)) == i)
                arr = noode.Tdata.get(j);
                if(arr[noode.id]==i)
                    pass.add(noode.Tdata.get(j));
                    //pass.add(arr);
            }
            //find max entropy gain wrt pass for those where marrk[n]=0
            k=0; l=0; m=0;
            //for (j=0;j<14;j++) System.out.print(noode.marrk[j]+ "  ");
            //System.out.println();
            for (j=0;j<14;j++)
            {
                if(noode.marrk[j]!=1)
                {
                    m=entropyGain(pass,j);
                    if(m>l)
                    {
                        l=m;
                        k=j;
                    }
                    //else
                      //  System.out.println("jaa raha hai bhaiya");
                }
            }
            if(l==0)
            {
                //noode.leaf=1;
                Integer [] refer = new Integer[14];
                for (j=0;j<14;j++) refer[j]=noode.marrk[j];
                Noode_2 ptr = new Noode_2(noode.id,noode.Tdata,refer);
                ptr.leaf=1;
                noode.childs.add(ptr);
                
                //return;
            }
            else
            {
            //recursively call makeTree for max entropy gain reference it to child I
            Integer [] refer = new Integer[14];
            for (j=0;j<14;j++) refer[j]=noode.marrk[j]; 
            Noode_2 ptr = new Noode_2(k,pass,refer);
            makeTree(ptr);
            //makeTree(ptr.Tdata,ptr);
            //if(ptr!=null)
            noode.childs.add(ptr);
            }
        }
        return;
    }

    public static double entropyGain(ArrayList <Integer []> plist, int id)
    {
        int i,j,t,f;
        double eg,k;
        Integer [] arr; t=0; f=0;
        if(plist.size()==0) return 0;
        for (i=0;i<plist.size();i++)
        {
            arr = plist.get(i);
            if(arr[14]==1) t++;
            else f++;
        }
        eg = entropy(t,f);
        for (i=0;i<count[id];i++)
        {
            t=0; f=0;
            for (j=0;j<plist.size();j++)
            {
                arr=plist.get(j);
                if(arr[id]==i)
                {
                    if(arr[14]==1) t++;
                    else f++;
                }
            }
            k = entropy(t,f);
            eg = eg-((((double)t+(double)f)/((double)plist.size()))*k);
        }
        //if(eg<0) return -1*eg;
        //else return eg;
        return eg;
    }

    public static double entropy(int t, int f)
    {
        double p1, p2;
        if((t==0) || (f==0)) return 0;
        if((t+f)>0)
        {
            p1=(double)t/(double)(t+f); p2=(double)f/(double)(t+f);
            return -1*((p1*(Math.log(p1)/Math.log(2)))+(p2*(Math.log(p2)/Math.log(2))));
        }
        else return 0;
    }

    public static void testData()
    {
        String FileLoc = "/home/hemvats/Desktop/ML_assns/ML_assn2_7/ID3_1test1.txt";
        BufferedReader br = null;
        String line,s;
        String lineVector[];
        Integer i,j,k,flag,n,l; 
        Integer [] arr;
        //ID3_1_2 obj = new ID3_1_2();
        //int ct=1;
        try
        {
            br = new BufferedReader(new FileReader(FileLoc));
            while((line = br.readLine())!=null)
            {
                lineVector = line.split(",");
                if(lineVector.length==(15))
                {
                    arr = new Integer[15];

                    //int ct=1;
                    //try{
                    //for last attr
                    if(lineVector[14].equals(" >50K."))arr[14]=1;
                    else arr[14]=0;

                    //for first attr
                    if(lineVector[0].equals(" ?")) arr[0]=-1;
                    else if(Integer.parseInt(lineVector[0].trim())<=30) arr[0]=0;
                    else if(Integer.parseInt(lineVector[0].trim())<=45) arr[0]=1;
                    else if(Integer.parseInt(lineVector[0].trim())<=60) arr[0]=2;
                    else arr[0]=3;

                    //for 2nd attr
                    flag=0;
                    for (i=0;i<strWorkClass.length;i++)
                    {
                        if(lineVector[1].equals(strWorkClass[i]))
                        {
                            arr[1]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[1]=-1;

                    //for 3rd attr
                    //if(lineVector[2].equals(" ?")) arr.fnl=-1;
                    //try
                    //{
                        if(lineVector[2].equals(" ?")) arr[2]=-1;   
                        else if(Integer.parseInt(lineVector[2].trim())<=60000) arr[2]=0;
                        else arr[2]=1;
                    //}
                    //catch (NumberFormatException ex){arr.fnl=1;}
                    

                    //for 4th attr
                    flag=0;
                    for (i=0;i<strEducation.length;i++)
                    {
                        if(lineVector[3].equals(strEducation[i]))
                        {
                            arr[3]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[3]=-1;

                    //for 5th attr
                    if(lineVector[4].equals(" ?")) arr[4]=-1;
                    else if(Integer.parseInt(lineVector[4].trim())<=8) arr[4]=0;
                    else arr[4]=1;

                    //for 6th attr
                    flag=0;
                    for (i=0;i<strMartial.length;i++)
                    {
                        if(lineVector[5].equals(strMartial[i]))
                        {
                            arr[5]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[5]=-1;

                    //for 7th attr
                    flag=0;
                    for (i=0;i<strOccupation.length;i++)
                    {
                        if(lineVector[1].equals(strOccupation[i]))
                        {
                            arr[6]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[6]=-1;

                    //for 8th attr
                    flag=0;
                    for (i=0;i<strRelationship.length;i++)
                    {
                        if(lineVector[7].equals(strRelationship[i]))
                        {
                            arr[7]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[7]=-1;

                    //for 9th attr
                    flag=0;
                    for (i=0;i<strRace.length;i++)
                    {
                        if(lineVector[8].equals(strRace[i]))
                        {
                            arr[8]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[8]=-1;

                    //for 10th attr
                    flag=0;
                    for (i=0;i<strSex.length;i++)
                    {
                        if(lineVector[9].equals(strSex[i]))
                        {
                            arr[9]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[9]=-1;

                    //for 11th attr;
                    if(lineVector[10].equals(" ?")) arr[10]=-1;
                    else if(Integer.parseInt(lineVector[10].trim())<=10000) arr[10]=0;
                    else arr[10]=1;

                    //for 12th attr
                    if(lineVector[11].equals(" ?")) arr[11]=-1;
                    else if(Integer.parseInt(lineVector[11].trim())<=2000) arr[11]=0;
                    else arr[11]=1;

                    //for 13th attr
                    if(lineVector[12].equals(" ?")) arr[12]=-1;
                    else if(Integer.parseInt(lineVector[12].trim())<=47) arr[12]=0;
                    else arr[12]=1;

                    //for 14th attr
                    flag=0;
                    for (i=0;i<strCountry.length;i++)
                    {
                        if(lineVector[13].equals(strCountry[i]))
                        {
                            arr[13]=i;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0) arr[13]=-1;
                    //}
                    //catch (NumberFormatException ex) {System.out.println("\nexception occured beta "+ ct); ct=ct+1;}
                    TestData.add(arr);
                    //TrainingData.add(arr);
                }
            }
        }
        catch (FileNotFoundException e)
            {e.printStackTrace();}
        catch(IOException e)
            {e.printStackTrace();}
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }

        //Assigning value to missing attrs
        int cnt []; k=0;

        //for 2nd attr
        n=strWorkClass.length; j=0; 
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0; 
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[1]!=-1)
            {
                cnt[arr[1]] = cnt[arr[1]]+1;
                if(cnt[arr[1]]>j)
                {
                    j=cnt[arr[1]];
                    k=arr[1];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[1]==-1)
            {
                arr[1]=k;   
            }
        }

        //for 1st attr
        n=4; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[0]!=-1)
            {
                cnt[arr[0]] = cnt[arr[0]]+1;
                if(cnt[arr[0]]>j)
                {
                    j=cnt[arr[0]];
                    k=arr[0];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[0]==-1)
            {
                arr[0]=k;   
            }
        }

        //for 3rd attr
        n=2; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[2]!=-1)
            {
                cnt[arr[2]] = cnt[arr[2]]+1;
                if(cnt[arr[2]]>j)
                {
                    j=cnt[arr[2]];
                    k=arr[2];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[1]==-1)
            {
                arr[2]=k;   
            }
        }

        //for 4th attr
        n=strEducation.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[3]!=-1)
            {
                cnt[arr[3]] = cnt[arr[3]]+1;
                if(cnt[arr[3]]>j)
                {
                    j=cnt[arr[3]];
                    k=arr[3];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[3]==-1)
            {
                arr[3]=k;   
            }
        }

        //for 5th attr
        n=2; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[4]!=-1)
            {
                cnt[arr[4]] = cnt[arr[4]]+1;
                if(cnt[arr[4]]>j)
                {
                    j=cnt[arr[4]];
                    k=arr[4];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[4]==-1)
            {
                arr[4]=k;   
            }
        }

        //for 6th attr
        n=strMartial.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[5]!=-1)
            {
                cnt[arr[5]] = cnt[arr[5]]+1;
                if(cnt[arr[5]]>j)
                {
                    j=cnt[arr[5]];
                    k=arr[5];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[5]==-1)
            {
                arr[5]=k;   
            }
        }

        //for 7th attr
        n=strOccupation.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[6]!=-1)
            {
                cnt[arr[6]] = cnt[arr[6]]+1;
                if(cnt[arr[6]]>j)
                {
                    j=cnt[arr[6]];
                    k=arr[6];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[6]==-1)
            {
                arr[6]=k;   
            }
        }

        //for 8th attr
        n=strRelationship.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[7]!=-1)
            {
                cnt[arr[7]] = cnt[arr[7]]+1;
                if(cnt[arr[7]]>j)
                {
                    j=cnt[arr[7]];
                    k=arr[7];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[7]==-1)
            {
                arr[7]=k;   
            }
        }

        //for 9th attr
        n=strRace.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[8]!=-1)
            {
                cnt[arr[8]] = cnt[arr[8]]+1;
                if(cnt[arr[8]]>j)
                {
                    j=cnt[arr[8]];
                    k=arr[8];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[8]==-1)
            {
                arr[8]=k;   
            }
        }

        //for 10th attr
        n=strSex.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[9]!=-1)
            {
                cnt[arr[9]] = cnt[arr[9]]+1;
                if(cnt[arr[9]]>j)
                {
                    j=cnt[arr[9]];
                    k=arr[9];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[9]==-1)
            {
                arr[9]=k;   
            }
        }

        //for 11th attr
        n=2; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[10]!=-1)
            {
                cnt[arr[10]] = cnt[arr[10]]+1;
                if(cnt[arr[10]]>j)
                {
                    j=cnt[arr[10]];
                    k=arr[10];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[10]==-1)
            {
                arr[10]=k;  
            }
        }

        //for 12th attr
        n=2; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[11]!=-1)
            {
                cnt[arr[11]] = cnt[arr[11]]+1;
                if(cnt[arr[11]]>j)
                {
                    j=cnt[arr[11]];
                    k=arr[11];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[11]==-1)
            {
                arr[11]=k;  
            }
        }

        //for 13th attr
        n=2; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[12]!=-1)
            {
                cnt[arr[12]] = cnt[arr[12]]+1;
                if(cnt[arr[12]]>j)
                {
                    j=cnt[arr[12]];
                    k=arr[12];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[12]==-1)
            {
                arr[12]=k;  
            }
        }

        //for 14th attr
        n=strCountry.length; j=0;
        cnt = new int [n];
        for (i=0;i<n;i++) cnt[i]=0;
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[13]!=-1)
            {
                cnt[arr[13]] = cnt[arr[13]]+1;
                if(cnt[arr[13]]>j)
                {
                    j=cnt[arr[13]];
                    k=arr[13];
                }
            }
        }
        for (i=0;i<TestData.size();i++)
        {
            arr = TestData.get(i);
            if(arr[13]==-1)
            {
                arr[13]=k;  
            }
        }

        double z=tellAccuracy();
        //System.out.println(amax);
    }

    public static double tellAccuracy()
    {
        int i,j,k,p1,p2;
        Integer [] arr; p1=0; p2=0;
        for (i=0;i<TestData.size();i++)
        {
            arr=TestData.get(i);
            k=tellVerdict(arr);
            System.out.print(k+" ");
            if(k==arr[14]) p1++;
            else p2++;
        }
        System.out.println("The accuracy is "+ (((double)p1)/((double)p1+(double)p2))*100+"%");
        amax=(((double)p1/((double)p1+(double)p2))*100);
        return amax;
    }
    
    public static int tellVerdict (Integer [] arr)
    {
        Integer [] vrr;
        int i,j,k,p1,p2;
        Noode_2 anode;
        anode = root;
        while(anode.leaf!=1)
        {
            anode=anode.childs.get(arr[anode.id]);
        }
        p1=0; p2=0;
        if(anode.leaf==1)
        {
            for(i=0;i<anode.Tdata.size();i++)
            {
                vrr=anode.Tdata.get(i);
                if(vrr[anode.id]==arr[anode.id])
                {
                    if(vrr[14]==1) p1++;
                    else p2++;
                }
            }
        }
        if(p1>=p2) return 1;
        else return 0;
    }

    public static void pruneTree()
    {
        ct=0;
        //Noode_2 ck=root_2.childs.get(0);
        //ck.leaf=1;
        for (int i=0;i<14;i++)
            dfs(root_2);
        //for(int i=0;i<2;i++)
          //  dfs(root_2);
    }

    public static void dfs(Noode_2 ruut)
    {
        Noode_2 next; double k;
        int flag=0;
        
        //static int ct;
        
        if(ruut.leaf==1) return;
        
        if(ct>500) return; 
        
        for (int i=0;i<ruut.childs.size();i++)
        {
            next=ruut.childs.get(i);
            if(ct>500) return;
            if(next.leaf==1)
            {
                flag=1;
                ruut.leaf=1;
                k = tellAccuracy_2();
                System.out.println(k);
                if(k>amax) 
                {
                    
                    ct=0;

                    amax=k;
                    return;
                }
                else
                {
                    
                    ct++;
                    
                    ruut.leaf=0;
                    continue;
                }
            }
            else
            {
                dfs(next);
            }
        }
        if(flag==1) ruut.leaf=1;

    }

    public static double tellAccuracy_2()
    {
        int i,j,k,p1,p2;
        double y;
        Integer [] arr; p1=0; p2=0;
        for (i=0;i<TestData.size();i++)
        {
            arr=TestData.get(i);
            k=tellVerdict_2(arr);
            //System.out.print(k+" ");
            if(k==arr[14]) p1++;
            else p2++;
        }
        //System.out.println("The accuracy is "+ (((double)p1)/((double)p1+(double)p2))*100+"%");
        y=((double)p1/((double)p1+(double)p2))*100;
        return y;
    }

    public static int tellVerdict_2 (Integer [] arr)
    {
        Integer [] vrr;
        int i,j,k,p1,p2;
        Noode_2 anode;
        anode = root_2;
        while(anode.leaf!=1)
        {
            anode=anode.childs.get(arr[anode.id]);
        }
        p1=0; p2=0;
        if(anode.leaf==1)
        {
            for(i=0;i<anode.Tdata.size();i++)
            {
                vrr=anode.Tdata.get(i);
                if(vrr[anode.id]==arr[anode.id])
                {
                    if(vrr[14]==1) p1++;
                    else p2++;
                }
            }
        }
        if(p1>=p2) return 1;
        else return 0;
    }

    public static void treeTraversal(Noode_2 rute)
    {
        if(rute.leaf==1)
        {
            System.out.print(rute.id+" ");
            //System.out.println("This was leaf");
            return;
        }
        System.out.print(rute.id+" ");
        for (int i=0;i<rute.childs.size();i++)
        {
            treeTraversal(rute.childs.get(i));
        }
    }

    public static int findHeight(Noode_2 rute)
    {
        if(rute.leaf==1)
        {
            return 1;
        }
        int k,m,i; m=0;
        for (i=0;i<rute.childs.size();i++)
        {
            k=findHeight(rute.childs.get(i));
            m=Math.max(m,k);
        }
        return m+1;
    }
	
}

class Person_1
{
	int age;
	int work;
	int fnl;
	int ed;
	int ednum;
	int mar;
	int ocp;
	int rel;
	int race;
	int sex;
	int capgain;
	int caploss;
	int hrspw;
	int cntry;
	int ans;

}




/*class Node
{
	int flag=0;
	ArrayList <Person> ptr = new ArrayList <Person>();
	int visit [] = new int [15];
	Node ()
	{
		int i;
		for (i=0;i<15;i++) visit[i]=0;
	}
}*/