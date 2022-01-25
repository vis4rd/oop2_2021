import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.nio.charset.Charset;
// import java.nio.Files;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader( System.in ) );
        String file1 = "";
        String file2 = "";
        try
        {
            System.out.print("Provide a name of the first file: ");
            if( (file1 = stdin.readLine()) == null )
            {
                throw new IOException();
            }
            System.out.print("Provide a name of the second file: ");
            if( (file2 = stdin.readLine()) == null )
            {
                throw new IOException();
            }
            // System.out.println( "sqrt(x)=" + Math.sqrt(x) );
        }
        catch(IOException e)
        {
            System.err.println( "IOException!" );
        }

        // sanity check
        if(!Files.exists(Paths.get(file1)) || !Files.exists(Paths.get(file2)))
        {
            System.out.println("Given file does not exist.");
            System.exit(0);
        }

///////////////////////////////////////////////////////////////////////////////////

        Path path1 = Paths.get(file1);
        Path path2 = Paths.get(file2);
        Charset charset = Charset.forName("UTF-8");
        var strx1 = new ArrayList<String>();
        var strx2 = new ArrayList<String>();
        var stry1 = new ArrayList<String>();
        var stry2 = new ArrayList<String>();
        var x1 = new ArrayList<Double>();
        var x2 = new ArrayList<Double>();
        var y1 = new ArrayList<Double>();
        var y2 = new ArrayList<Double>();
        try (BufferedReader reader = Files.newBufferedReader(path1, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                strx1.add(line.split(" ")[0].strip());
                stry1.add(line.split(" ")[1].strip());
                x1.add(Double.valueOf(line.split(" ")[0]));
                y1.add(Double.valueOf(line.split(" ")[1]));
            }
        }
        catch (IOException x)
        {
            System.err.println("IOException " + x);
        }
        try (BufferedReader reader = Files.newBufferedReader(path2, charset))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                strx2.add(line.split(" ")[0].strip());
                stry2.add(line.split(" ")[1].strip());
                x2.add(Double.valueOf(line.split(" ")[0]));
                y2.add(Double.valueOf(line.split(" ")[1]));
            }
        }
        catch (IOException x)
        {
            System.err.println("IOException " + x);
        }

///////////////////////////////////////////////////////////////////////////////////

        var result_y = new ArrayList<Double>();
        var smaller = 0;

        int j = 0;
        for(int i = 0; i < x1.size(); i++)
        {
            if(strx1.get(i).compareTo(strx2.get(i))==0)
                result_y.add(y1.get(i) + y2.get(i));
        }

        // for(var i : result_y)
        // {
        //     System.out.println(i);
        // }

/////////////////////////////////////////////////////////////////////////////////

        BufferedReader stdin2 = new BufferedReader(new InputStreamReader( System.in ) );
        String fileout = "";
        var okay = false;
        try
        {
            // System.out.println(okay);
            while(!okay)
            {
                System.out.print("Podaj nazwe wyjsciowego pliku: ");
                okay = ((fileout = stdin.readLine()) != null);

                Path path = Paths.get(fileout);
                if(Files.exists(path))
                {
                    System.out.println("Taki plik istnieje, chcesz go nadpisac? (yes/no)");
                    String ans = "";
                    if((ans = stdin.readLine()) != null)
                    {
                        if(ans.compareTo("yes") == 0)
                        {
                            okay = true;
                            continue;
                        }
                        else if(ans.compareTo("no") == 0)
                        {
                            okay = false;
                        }
                        else
                        {
                            okay = false;
                        }
                    }
                }
                else // path does not exist, we can safely create a new file
                {
                    okay = true;
                }
            }

            // saving to file
            Path path = Paths.get(fileout);
            var out = Files.newBufferedWriter(path, charset);
            for(int i = 0; i < result_y.size(); i++)
            {
                out.write(result_y.get(i)+"\n");
            }
            out.close();
            
        }
        catch(IOException e)
        {
            System.err.println( "IOException!" );
        }
    }
}
