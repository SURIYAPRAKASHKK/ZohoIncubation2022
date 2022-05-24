package Task2;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

class StringMethods{
	char [] ca;
    String mystring1;
    String astr;
    static StringMethods cobj=   new StringMethods("suriya * ");
    
    
    public StringMethods(String str1) {
    	this.mystring1 = str1;
    }
    
	public int myLength() throws IOException {	
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] ca = o.myToCharArray();
		int i = 0;
		
		if(str == null) {
			return 0;
		}		
		for(char c: ca) {
			i++;
		}
		
		return i;
		
	}
	
	public char myCharAt(int index) {
		String st = this.mystring1;
		//char [] charr = new char[st.length()];
		StringMethods o = new StringMethods(st);
		if ((index < 0) || (index >= st.length())) {
			throw new StringIndexOutOfBoundsException(index); 
		 }
		
		try {
			this.ca = o.myToCharArray();
		 }
		
		catch (IOException e) {
			System.out.println(e);
		}		
	
		return (char)ca[index];    
	}
	
	public char[] myToCharArray() throws IOException  {	
		String st = this.mystring1;
	    StringReader reader = new StringReader(st); 
	    int k = 0; 
	    int i = 0; 
	    char[] output = new char[st.length ()]; 
	    
	    while ((k = reader.read()) != -1){ 
	    	output[i] = ((char) k); 
	    	i++; 
	      }   	    
	    
	    return output;
	}
	
	public int myCodePointAt(int index) throws IOException {
		String str = this.mystring1;
		if(index < 0 || index > str.length()) {
			throw new StringIndexOutOfBoundsException();
		}
		
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();		
		return (int)charr[index];
	}
	
	public int myCodePointBefore(int index) throws IOException {
		String str = this.mystring1;
		if(index < 1 || index > str.length()) {
			throw new StringIndexOutOfBoundsException();
		}
		
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();		
		return (int)charr[index-1];
	}
	
	public int myCodePointCount(int startindex, int endindex) {
		if(startindex > endindex || startindex > this.mystring1.length() || endindex > this.mystring1.length() || startindex < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return endindex - startindex;
	}
	
	public int myCompareTo(String st2) throws IOException{
		//2 charArray for store the string as 2 char array 
		String str1 = this.mystring1;
		String str2 = st2;
		char [] ca1 = new char[str1.length()];
		char [] ca2 = new char[str2.length()];
		//2 int array for store respect ascii values
		int [] ia1 = new int[str1.length()];
		int [] ia2 = new int[str2.length()];		
		StringMethods o1 = new StringMethods(str1);
		StringMethods o2 = new StringMethods(str2);	
		//String are stored inside charArrays
		ca1 = o1.myToCharArray();
		ca2 = o2.myToCharArray();		
		//Char are stored as ascii values in int array		
		for(int i = 0; i<ca1.length; i++) {
			ia1[i] = (int)ca1[i];
		}
		
		for(int j = 0; j<ca2.length; j++) {
			ia2[j] = (int)ca2[j];
		}
		
		//Case1: If strings are exactly same return 0
		if(str1 == str2) {
			System.out.println("str equals");
			return 0;
		}
		//Case 2: if strings not same 				
		//Case2.1: if string lengths are differ return difference
		else if(ia1.length == ia2.length) {
			for(int k = 0; k < ia1.length; k++) {
				if(ia1[k] != ia2[k]) {
					//System.out.println("len equal 2.1");
					return ia1[k] - ia2[k];
				}
			}
		}
		//Case3: if String length not equals length diff						
		else if(ia1.length != ia2.length){
			//System.out.println("len not equal");
			return ia1.length - ia2.length;
		}	
		return 0;
	}
	
	public String myConcat(String st2) {
		String str1 = this.mystring1;		
		return str1 + st2;
	}
	
	public boolean myEquals(Object o) {
		if(this.mystring1 == (String) o) {
			return true;
		}
		
		return false;
	}
						
	public boolean myIsEmpty() {
		if(this.mystring1.length() == 0) {
			return true;
		}
		
		return false;	
	}
	
	public boolean myContains(CharSequence cs) throws IOException {
		String str1 = this.mystring1;
		String str2 = (String)cs;
		
		boolean achieved = false;
		StringMethods o = new StringMethods(str1);
		StringMethods o1 = new StringMethods(str2);
		char [] charr1 = o.myToCharArray();
		char [] charr2 = o1.myToCharArray();
		int count = 0;
		int i = 0;
		if(str2 == "") {
			return true;
		}
		
		System.out.println(charr1);
		System.out.println(charr2);
		if(charr1.length > charr2.length) {
			while(i < charr1.length) {
				if(charr1[i] == charr2[0]) {
					for(int j = 0; j <charr2.length; j++) {
						if(charr1[i] == charr2[j]) {
							i++;
							count++;
						}
					}
					if(count == charr2.length) {
						return true;
					}
				}
				i++;
			}
		}
		return achieved;
			
	}
	
	public boolean myContains1(CharSequence cs) throws IOException {
		String str1 = this.mystring1;
		String str2 = (String)cs;
		List<String> chunk = new ArrayList<String>();
		
		StringMethods o1 = new StringMethods(str1);
		StringMethods o2 = new StringMethods(str2);
		
		char[] charr1 = o1.myToCharArray();
		char[] charr2 = o2.myToCharArray();
		//System.out.println(charr1);
		//System.out.println(charr2);
		boolean status = false;
		
		for(int i = 0; i < charr1.length - (charr2.length -1); i++) {
			String s = "";
			for(int j = i; j < (i + charr2.length); j++) {
				s += charr1[j];
			}
			chunk.add(s);
		}
		
		//System.out.println(chunk);
		//System.out.println(str2);
		for(String s: chunk) {
			if(s.equals(str2)) {
				status = true;
			}
			
		}
		//System.out.println(chunk);
		return status;
		
	}
	
	
	public String mySubString(int beginindex) throws IOException {
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();
		String str1 = "";
		if(beginindex < 0 || beginindex > str.length()) {
			throw new StringIndexOutOfBoundsException();
		}		
		
		for(int i = beginindex; i < charr.length; i++) {
			str1 += charr[i];
		}
		return str1;
	}
	
	public String mySubString(int beginindex, int endindex) throws IOException {
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();
		String str1 = "";
		if(beginindex < 0 || beginindex > str.length()) {
			throw new StringIndexOutOfBoundsException();
		}
		
		for(int i = beginindex; i < endindex; i++) {
			str1 += charr[i];
		}
		return str1;
	}
	
	public String myToLowerCase() throws IOException {
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();
		String returnstr = "";
		if(str == "\0") {
			throw new NullPointerException();
		}
		
		if(str == "") {
			return "";
		}
		
		for(int i = 0; i < charr.length; i++) {
			if(charr[i] >= 'A' && charr[i] <= 'Z' ) {
				returnstr += (char)((int)charr[i] + 32);
			}
			else {
				returnstr += charr[i];
			}
		}
		return returnstr;
		
	}
	
	public String myToUpperCase() throws IOException {
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();
		String returnstr = "";
		if(str == "\0") {
			throw new NullPointerException();
		}
		
		if(str == "") {
			return "";
		}
		
		for(int i = 0; i < charr.length; i++) {
			if(charr[i] >= 'a' && charr[i] <= 'z' ) {
				returnstr += (char)((int)charr[i] - 32);
			}
			else {
				returnstr += charr[i];
			}
		}
		return returnstr;
		
	}	
	
	public int myIndexOf(char ch) throws IOException {
		String str = this.mystring1;
		StringMethods o = new StringMethods(str);
		char [] charr = o.myToCharArray();
		int i = 0;
		for(i=0; i<charr.length; i++) {
			if(charr[i] == ch) {
				break;
			}
					
		}
		return i;		
	}
	
	public String [] mySplit(char c) throws IOException {
		String str = this.mystring1;
		char [] charr = cobj.myToCharArray();
		//System.out.println(charr);
		List<String> al = new ArrayList<String>();
		String s = "";
		
		for(int i = 0; i < charr.length; i++){
			if(charr[i] != c) {
				s += charr[i];
			}
			else {
				al.add(s);
				s = "";
			}
		}
		al.add(s);
		String []starr = new String[al.size()];
		int index = 0;
		for(String t: al) {
			starr[index] = t;
			index ++;
		}
		
		return starr;
		}
		
	public String myTrim() throws IOException {
		String str = this.mystring1;
		char [] charr = cobj.myToCharArray();
		String op = "";
		int i = 0;
		int charbeginindex = 0;
		int charendindex = charr.length-1;
		while(i < charr.length) {
			if(charr[i] == ' ')
				i++;
			else {
				break;
			}
		}
		charbeginindex = i;
		//System.out.println(charbeginindex);
		int j = charr.length-1;
		while(j > 0) {	
			if(charr[j] == ' ') {
				j--;
			}
			else {
				break;
			}	
		}
		for(int x = charbeginindex; x <= charendindex; x++) {
			op += charr[x];
		}	
			return op;
	}
		 	
	public static void main(String [] args) throws IOException {
		StringMethods obj = new StringMethods("Suririya");
		 char [] ch = cobj.myToCharArray();
		System.out.println(ch);
		System.out.println("----myToCharArrayMethod call end--------");
		System.out.println(obj.myCharAt(5));
		System.out.println("----mycharAtMethod call end--------");
		System.out.println(obj.myCompareTo("SURIYA"));
		System.out.println("----myCompareToMethod call end--------");
		System.out.println(obj.myLength());
		System.out.println("----mylengthMethod call end--------");
		System.out.println(cobj.myConcat("is good"));
		System.out.println("----myconcatMethod call end--------");
		System.out.println(obj.myEquals("MainStirng"));
		System.out.println("----myEqualsMethod call end--------");
		System.out.println(obj.myIsEmpty());
		System.out.println("-------myIsEmptyMethod call end--------");
		System.out.println(obj.myContains("riy"));
		System.out.println("-------myContainsMethod call end--------");
		System.out.println(obj.mySubString(1));
		System.out.println(obj.mySubString(2,4));
		System.out.println("-------mySubString---------");
		System.out.println(obj.myCodePointAt(0));
		System.out.println("-----------myCodePointAt------------");
		System.out.println(obj.myCodePointBefore(1));
		System.out.println("------------------myCodePointBefore----------------");
		System.out.println(obj.myCodePointCount(1, 6));
		System.out.println("----------myCodePointCount---------");
		System.out.println(obj.myToLowerCase());
		System.out.println("----------myToLowerCase end-------------");
		System.out.println(obj.myToUpperCase());
		System.out.println("---------------myToUpperCase end------------");
		System.out.println(obj.myIndexOf('a'));
		System.out.println("----------myIndexOf end---------------");
		String [] op= obj.mySplit('*');
		for(String s: op)
			System.out.println(s);
		System.out.println(obj.myTrim());
		System.out.println(obj.myContains1("riy"));
	}
}
	
