using System.Text;

namespace EIKMAX
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var reader = new Reader(); 
            StringBuilder sb = new StringBuilder();

            var numInput = reader.NextInt();  
            var k = reader.NextInt();

            var numbers = new List<int>();

            for ( int i = 0; i < numInput; i++ ) { 
                var eachNum = reader.NextInt();
                numbers.Add( eachNum );
            }

            numbers = numbers.OrderByDescending( x => x ).Take(k).ToList();
            
            foreach (var show in numbers) { 
                Console.Write( show + " " );
            }

        }
    }

    class Reader
    {
        private int index = 0;
        private string[] tokens;
        public string Next()
        {
            while (tokens == null || tokens.Length <= index)
            {
                tokens = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
                index = 0;
            }
            return tokens[index++];
        }
        public int NextInt()
        {
            return int.Parse(Next());
        }

        public long NextLong()
        {
            return long.Parse(Next());
        }

        public double NextDouble()
        {
            return double.Parse(Next());
        }
    }
}
