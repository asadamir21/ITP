/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

/**
 *
 * @author Asad
 */
public class JavaApplication22 {

    private int[] genarray(int n) {
        int[] A;
        int i;
        int S;

        A = new int[(n + 1)];
        S = 0;
        System.out.print("The input array:\n");
        for (i = 1; i <= n; ++i)
        {
               A[i] = 1 + tangible.RandomNumbers.nextNumber() % 99;
               System.out.printf("%-2d  ", A[i]);
               if (i % 20 == 0)
               {
                       System.out.print("\n");
               }
               S += A[i];
        }
        if (i % 20 != 1)
        {
                System.out.print("\n");
        }
        // A[0] = 1 + rand() % S;
        // A[0] = (S/2) + (rand() % (S/2));
        A[0] = (2 * S / 3) + (tangible.RandomNumbers.nextNumber() % (S / 3));
        if ((A[0] & 1) != (S & 1))
        {
                --A[0];
        }
        if ((tangible.RandomNumbers.nextNumber() & 1) != 0)
        {
                A[0] = -A[0];
        }
        System.out.printf("S = %d\n", S);
        System.out.printf("T = %d\n", A[0]);
        return A;
     }

     private void realizable(int[] A, int n, int T)
     {
        int S;
        int s;
        int i;
        int j;
        String[] P; // P[i][j] stores 0 if unrealizable, or +/- if realizable

        S = 0;
        for (i = 1; i <= n; ++i)
        {
                S += A[i];
        }
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'malloc' has no equivalent in Java:
     //C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'sizeof':
        P = (String)malloc((n + 1) * sizeof(String));
        for (i = 0; i <= n; ++i)
        {
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'malloc' has no equivalent in Java:
               P[i] = (String)malloc((2 * S + 1) * (Character.SIZE / Byte.SIZE));
               for (j = -S; j <= S; ++j)
               {
                       P[i][j + S] = '\0';
               }
        }
        P[0][S] = '.';
        s = 0;
        for (i = 1; i <= n; ++i)
        {
               s += A[i];
               for (j = -s; j <= s; ++j)
               {
                      if ((j - A[i] >= -S) && (P[i - 1][j - A[i] + S]))
                      {
                              P[i][j + S] = '+';
                      }
                      else if ((j + A[i] <= S) && (P[i - 1][j + A[i] + S]))
                      {
                              P[i][j + S] = '-';
                      }
               }
        }
        if (P[n][T + S])
        {
                System.out.printf("   The value %d is realizable\n", T);
        }
        else
        {
                System.out.printf("   The value %d is not realizable\n", T);
        }
        for (i = 0; i <= n; ++i)
        {
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'free' has no equivalent in Java:
                free(P[i]);
        }
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'free' has no equivalent in Java:
        free(P);
     }

     /* sol[] stores a sequence of n + and - signs to indicate the choice of
        the signs of the array elements. */
     private void printsol(int[] A, int n, tangible.RefObject<String> sol)
     {
        int S;
        int i;

        S = 0;
        for (i = 1; i <= n; ++i)
        {
               System.out.printf("%c%d", sol.argValue.charAt(i), A[i]);
               if (sol.argValue.charAt(i) == '+')
               {
                       S += A[i];
               }
               else if (sol.argValue.charAt(i) == '-')
               {
                       S -= A[i];
               }
               else
               {
                       fprintf(stderr, "*** Error: operator %d is %d\n", i, sol.argValue.intValue().charAt(i));
               }
        }
        System.out.printf(" =  %d\n", S);
     }

     private void showone(int[] A, int n, int T)
     {
        int S;
        int s;
        int i;
        int j;
        String[] P; // P[i][j] stores 0 if unrealizable, or +/- if realizable
        String sol;

        S = 0;
        for (i = 1; i <= n; ++i)
        {
                S += A[i];
        }
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'malloc' has no equivalent in Java:
     //C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'sizeof':
        P = (String)malloc((n + 1) * sizeof(String));
        for (i = 0; i <= n; ++i)
        {
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'malloc' has no equivalent in Java:
               P[i] = (String)malloc((2 * S + 1) * (Character.SIZE / Byte.SIZE));
               for (j = -S; j <= S; ++j)
               {
                       P[i][j + S] = '\0';
               }
        }
        P[0][S] = '.';
        s = 0;
        for (i = 1; i <= n; ++i)
        {
               s += A[i];
               for (j = -s; j <= s; ++j)
               {
                      if ((j - A[i] >= -S) && (P[i - 1][j - A[i] + S]))
                      {
                              P[i][j + S] = '+';
                      }
                      else if ((j + A[i] <= S) && (P[i - 1][j + A[i] + S]))
                      {
                              P[i][j + S] = '-';
                      }
               }
        }
        if (P[n][T + S])
        {
     //C++ TO JAVA CONVERTER TODO TASK: The memory management function 'malloc' has no equivalent in Java:
               sol = (String)malloc((n + 1) * (Character.SIZE / Byte.SIZE));
               j = T;
               i = n;
               while (i > 0)
               {
                      sol.charAt(i) = P[i][j + S];
                      if (sol.charAt(i) == '+')
                      {
                              j -= A[i];
                      }
                      else
                      {
                              j += A[i];
                      }

     //====================================================================================================
     //End of the allowed output for the Free Edition of C++ to Java Converter.

     //To subscribe to the Premium Edition, visit our website:
     //https://www.tangiblesoftwaresolutions.com/order/order-cplus-to-java.html
     //====================================================================================================


     //Helper class added by C++ to Java Converter:

     package tangible;

     //----------------------------------------------------------------------------------------
     //	Copyright © 2006 - 2019 Tangible Software Solutions, Inc.
     //	This class can be used by anyone provided that the copyright notice remains intact.
     //
     //	This class provides the ability to replicate the behavior of the C/C++ functions for 
     //	generating random numbers.
     //	'rand' converts to the parameterless overload of NextNumber
     //	'random' converts to the single-parameter overload of NextNumber
     //	'randomize' converts to the parameterless overload of Seed
     //	'srand' converts to the single-parameter overload of Seed
     //----------------------------------------------------------------------------------------
     public final class RandomNumbers
     {
             private static java.util.Random r;

             public static int nextNumber()
             {
                     if (r == null)
                             Seed();

                     return r.nextInt();
             }

             public static int nextNumber(int ceiling)
             {
                     if (r == null)
                             Seed();

                     return r.nextInt(ceiling);
             }

             public static void seed()
             {
                     r = new java.util.Random();
             }

             public static void seed(int seed)
             {
                     r = new java.util.Random(seed);
             }
     }

     //Helper class added by C++ to Java Converter:

     package tangible;

     //----------------------------------------------------------------------------------------
     //	Copyright © 2006 - 2019 Tangible Software Solutions, Inc.
     //	This class can be used by anyone provided that the copyright notice remains intact.
     //
     //	This class is used to replicate the ability to pass arguments by reference in Java.
     //----------------------------------------------------------------------------------------
     public final class RefObject<T>
     {
             public T argValue;
             public RefObject(T refArg)
             {
                     argValue = refArg;
             }
     }

     //Helper class added by C++ to Java Converter:

     package tangible;

     //----------------------------------------------------------------------------------------
     //	Copyright © 2006 - 2019 Tangible Software Solutions, Inc.
     //	This class can be used by anyone provided that the copyright notice remains intact.
     //
     //	This class provides the ability to convert basic C++ 'cin' behavior.
     //----------------------------------------------------------------------------------------
     public final class ConsoleInput
     {
             private static boolean goodLastRead = false;
             public static boolean lastReadWasGood()
             {
                     return goodLastRead;
             }

             public static String readToWhiteSpace(boolean skipLeadingWhiteSpace)
             {
                     String input = "";
                     char nextChar;
                     while (Character.isWhitespace(nextChar = (char)System.in.read()))
                     {
                             //accumulate leading white space if skipLeadingWhiteSpace is false:
                             if (!skipLeadingWhiteSpace)
                             {
                                     input += nextChar;
                             }
                     }
                     //the first non white space character:
                     input += nextChar;

                     //accumulate characters until white space is reached:
                     while (!Character.isWhitespace(nextChar = (char)System.in.read()))
                     {
                             input += nextChar;
                     }

                     goodLastRead = input.length() > 0;
                     return input;
             }

             public static String scanfRead()
             {
                     return scanfRead(null, -1);
             }

             public static String scanfRead(String unwantedSequence)
             {
                     return scanfRead(unwantedSequence, -1);
             }

             public static String scanfRead(String unwantedSequence, int maxFieldLength)
             {
                     String input = "";

                     char nextChar;
                     if (unwantedSequence != null)
                     {
                             nextChar = '\0';
                             for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
                             {
                                     if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
                                     {
                                             //ignore all subsequent white space:
                                             while (Character.isWhitespace(nextChar = (char)System.in.read()))
                                             {
                                             }
                                     }
                                     else
                                     {
                                             //ensure each character matches the expected character in the sequence:
                                             nextChar = (char)System.in.read();
                                             if (nextChar != unwantedSequence.charAt(charIndex))
                                                     return null;
                                     }
                             }

                             input = (new Character(nextChar)).toString();
                             if (maxFieldLength == 1)
                                     return input;
                     }

                     while (!Character.isWhitespace(nextChar = (char)System.in.read()))
                     {
                             input += nextChar;
                             if (maxFieldLength == input.length())
                                     return input;
                     }

                     return input;
	}
    }
}
}
}
