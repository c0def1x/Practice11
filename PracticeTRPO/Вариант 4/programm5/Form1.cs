using System;
using System.Windows.Forms;

namespace programm5
{
    public partial class Form1 : Form
    {
        static string st;
        static int i;
        static int j;
        static int n;
        static readonly string[] s = new string[20];
        static int kod;

        public Form1()
        {
            InitializeComponent();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            st = textBox1.Text;
            i = 0;
            CheckString();
            FormationResult();
        }

        private void FormationResult()
        {
            for (i = 0; i < j; i++)
            {
                if (s[i].Length == 3)
                {
                    n = 0;
                    while (n < 3)
                    {
                        kod += s[i][n];
                        n++;
                    }
                    kod /= 3;
                    textBox2.Text += (char)kod + " ";
                }
                else
                    textBox2.Text += s[i] + " ";
            }
        }

        private static void CheckString()
        {
            while (i < st.Length)
            {
                while (i < st.Length && st[i] != ' ' && st[i] != ',' && st[i] != '!' && st[i] != '?' && st[i] != '.')
                {
                    s[j] += st[i];
                    i++;
                }
                i++;
                j++;
            }
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Данная программа заменяет все трехбуквенные слова на символ, который равен среднему значению этих трех букв.");
        }
    }
}