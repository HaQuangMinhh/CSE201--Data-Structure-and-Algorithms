namespace EIDORM
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var reader = new Reader();
            var num = reader.NextInt();

            var count = 0;

            for (int i = 0; i < num; i++) { 
                var pi = reader.NextInt();   // số ng hiện đang sống 
                var qi = reader.NextInt(); // số ng tối đa của phòng

                if ( qi - pi >= 2 ) { 
                    count++ ;
                }
            }

            Console.WriteLine(count);
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
