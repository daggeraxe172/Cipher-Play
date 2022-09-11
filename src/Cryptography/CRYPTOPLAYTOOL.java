package Cryptography;

import java.awt.Point;

class PlayFairCipherEncryption
{
    public static int length = 0;

    public static String [][] table;

    public static String PlayFairCipherEncrypt(String sc)
    {
        String key = "SUDHARSAN";
        table = cipherTable(key);
        String input = parseString(sc);
        while(input.equals(""))
            input = parseString(sc);
        return cipher(input);
    }

    public static String parseString(String sc)
    {
        String parse = sc;
        parse = parse.toUpperCase();
        parse = parse.replaceAll("[^A-Z]", "");
        parse = parse.replace("J", "I");
        return parse;
    }

    public static String[][] cipherTable(String key)
    {

        String[][] playfairTable = new String[5][5];
        String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                playfairTable[i][j] = "";
        for(int k = 0; k < keyString.length(); k++)
        {
            boolean repeat = false;
            boolean used = false;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    if(playfairTable[i][j].equals("" + keyString.charAt(k)))
                    {
                        repeat = true;
                    }
                    else if(playfairTable[i][j].equals("") && !repeat && !used)
                    {
                        playfairTable[i][j] = "" + keyString.charAt(k);
                        used = true;
                    }
                }
            }
        }
        return playfairTable;
    }

    public static String cipher(String in)
    {
        length = in.length() / 2 + in.length() % 2;

        for(int i = 0; i < (length - 1); i++)
        {
            if(in.charAt(2 * i) == in.charAt(2 * i + 1))
            {
                in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                length = in.length() / 2 + in.length() % 2;
            }
        }
        String[] digraph = new String[length];

        for(int j = 0; j < length ; j++)
        {

            if(j == (length - 1) && in.length() / 2 == (length - 1))

                in = in + "X";
            digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
        }

        StringBuilder out = new StringBuilder();
        String[] encDigraphs;
        encDigraphs = encodeDigraph(digraph);
        for(int k = 0; k < length; k++)
            out.append(encDigraphs[k]);
        return out.toString();
    }

    public static String[] encodeDigraph(String[] di)
    {
        String[] encipher = new String[length];
        for(int i = 0; i < length; i++)
        {
            char a = di[i].charAt(0);
            char b = di[i].charAt(1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();

            if(r1 == r2)
            {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            }

            else if(c1 == c2)
            {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            }

            else
            {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            encipher[i] = table[r1][c1] + "" + table[r2][c2];
        }
        return encipher;
    }



    public static String decode(String out)
    {
        StringBuilder decoded = new StringBuilder();
        for(int i = 0; i < out.length() / 2; i++)
        {
            char a = out.charAt(2*i);
            char b = out.charAt(2*i+1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();
            if(r1 == r2)
            {
                c1 = (c1 + 4) % 5;
                c2 = (c2 + 4) % 5;
            }
            else if(c1 == c2)
            {
                r1 = (r1 + 4) % 5;
                r2 = (r2 + 4) % 5;
            }
            else
            {

                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            decoded.append(table[r1][c1]).append(table[r2][c2]);
        }

        return decoded.toString();
    }

    public static Point getPoint(char c)
    {
        Point pt = new Point(0,0);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                if(c == table[i][j].charAt(0))
                    pt = new Point(i,j);
        return pt;
    }

}

class PlayFairCipherDecryption
{

    public static int length = 0;

    public static String [][] table;

    public static String PlayFairCipherDecrypt(String sc)
    {
        String key = "SUDHARSAN";
        table = cipherTable(key);
        String input = parseString(sc);
        while(input.equals(""))
            input = parseString(sc);
        return decode(input);
    }

    public static String parseString(String sc)
    {
        String parse = sc;
        parse = parse.toUpperCase();
        parse = parse.replaceAll("[^A-Z]", "");
        parse = parse.replace("J", "I");
        return parse;
    }

    public static String[][] cipherTable(String key)
    {

        String[][] playfairTable = new String[5][5];
        String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                playfairTable[i][j] = "";
        for(int k = 0; k < keyString.length(); k++)
        {
            boolean repeat = false;
            boolean used = false;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    if(playfairTable[i][j].equals("" + keyString.charAt(k)))
                    {
                        repeat = true;
                    }
                    else if(playfairTable[i][j].equals("") && !repeat && !used)
                    {
                        playfairTable[i][j] = "" + keyString.charAt(k);
                        used = true;
                    }
                }
            }
        }
        return playfairTable;
    }

    public static String cipher(String in)
    {
        length = in.length() / 2 + in.length() % 2;

        for(int i = 0; i < (length - 1); i++)
        {
            if(in.charAt(2 * i) == in.charAt(2 * i + 1))
            {
                in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                length = in.length() / 2 + in.length() % 2;
            }
        }
        String[] digraph = new String[length];

        for(int j = 0; j < length ; j++)
        {

            if(j == (length - 1) && in.length() / 2 == (length - 1))

                in = in + "X";
            digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
        }

        StringBuilder out = new StringBuilder();
        String[] encDigraphs;
        encDigraphs = encodeDigraph(digraph);
        for(int k = 0; k < length; k++)
            out.append(encDigraphs[k]);
        return out.toString();
    }

    public static String[] encodeDigraph(String[] di)
    {
        String[] encipher = new String[length];
        for(int i = 0; i < length; i++)
        {
            char a = di[i].charAt(0);
            char b = di[i].charAt(1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();

            if(r1 == r2)
            {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            }

            else if(c1 == c2)
            {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            }

            else
            {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            encipher[i] = table[r1][c1] + "" + table[r2][c2];
        }
        return encipher;
    }



    public static String decode(String out)
    {
        StringBuilder decoded = new StringBuilder();
        for(int i = 0; i < out.length() / 2; i++)
        {
            char a = out.charAt(2*i);
            char b = out.charAt(2*i+1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();
            if(r1 == r2)
            {
                c1 = (c1 + 4) % 5;
                c2 = (c2 + 4) % 5;
            }
            else if(c1 == c2)
            {
                r1 = (r1 + 4) % 5;
                r2 = (r2 + 4) % 5;
            }
            else
            {

                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            decoded.append(table[r1][c1]).append(table[r2][c2]);
        }

        return decoded.toString();
    }

    public static Point getPoint(char c)
    {
        Point pt = new Point(0,0);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                if(c == table[i][j].charAt(0))
                    pt = new Point(i,j);
        return pt;
    }

}


public class CRYPTOPLAYTOOL {

    public static StringBuffer CaesarCipherEncryption(String text)
    {
        int s = 4;
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static StringBuffer CaesarCipherDecryption(String text)
    {
        int s = 4;
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +26 -s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +26
                        - s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static String MonoAlphabeticCipherEncryption(String s)
    {
        char[] p = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };
        char[] ch = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
                'V', 'B', 'N', 'M' };
        char[] c = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));
    }

    public static String MonoAlphabeticCipherDecryption(String s)
    {
        char[] p = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };
        char[] ch = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
                'V', 'B', 'N', 'M' };
        char[] p1 = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }

    public static String RailFenceBasicEncryption(String plainText)
    {
        int depth = 2;
        int len=plainText.length();
        int c=len/depth;
        char[][] mat=new char[depth][c];
        int k=0;

        StringBuilder cipherText= new StringBuilder();

        for(int i=0;i< c;i++)
        {
            for(int j = 0; j< depth; j++)
            {
                if(k!=len)
                    mat[j][i]=plainText.charAt(k++);
                else
                    mat[j][i]='X';
            }
        }
        for(int i = 0; i< depth; i++)
        {
            for(int j=0;j< c;j++)
            {
                cipherText.append(mat[i][j]);
            }
        }
        return cipherText.toString();
    }

    public static String RailFenceBasicDecryption(String cipherText)
    {
        int depth = 2;
        int len=cipherText.length();
        int c=len/depth;
        char[][] mat=new char[depth][c];
        int k=0;

        StringBuilder plainText= new StringBuilder();


        for(int i = 0; i< depth; i++)
        {
            for(int j=0;j< c;j++)
            {
                mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j = 0; j< depth; j++)
            {
                plainText.append(mat[j][i]);
            }
        }

        return plainText.toString();
    }

}
