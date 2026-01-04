We are required to convert a given integer into its corresponding roman numeral based on certain rules . 

1) If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.

2) If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).

3) Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.

for example : 
Integer : 3749
Roman : "MMMDCCXLIX"

Explanation :
1) 3000 : 1000(M) + 1000(M) + 1000(M) = MMM
2) 700 : 500(D) + 100(C) + 100(C) = DCC
3) 40 : XL as 10 (X) less of 50 (L) = XL
4) 9 : IX as 1 (I) less of 10 (X) = IX

So , 3749 = MMMDCCXLIX
