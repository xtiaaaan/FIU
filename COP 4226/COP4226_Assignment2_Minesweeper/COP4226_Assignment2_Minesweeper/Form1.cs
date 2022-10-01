using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Net.Mime.MediaTypeNames;

namespace COP4226_Assignment2_Minesweeper
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void Play(object sender, EventArgs e)
        {
            int row = 0, col = 0, mines = 0;//row*col >=18, mines <= row*col/2
            String text = "";
            Form2 f = null;
            if (easy.Checked)
            {
                row = col = 9;
                mines = 10;
                text = "Easy - " + textBox1.Text;
            }
            else if (medium.Checked)
            {
                row = col = 16;
                mines = 40;
                text = "Medium - " + textBox1.Text;
            }
            else if (expert.Checked)
            {
                row = 30;
                col = 16;
                mines = 99;
                text = "Expert - " + textBox1.Text;
            }
            else if (custom.Checked)
            {
                bool valid = false;
                using(Form3 dialog = new Form3())
                {
                    do
                    {
                        dialog.ShowDialog();
                        if (dialog.row > 0 && dialog.col > 0 && dialog.mines > 0)
                        {
                            row = dialog.row;
                            col = dialog.col;
                            mines = dialog.mines;
                            valid = true;
                        }
                        else
                        {
                            MessageBox.Show("Please enter integers greater than zero", "Positive integers only", MessageBoxButtons.OK);
                        }
                    } while (!valid);
                }
                text = "Custom - " + textBox1.Text;
                
            }
            else
                return;
            int size = Math.Min(30, 1000 / Math.Max(row, col));
            f = new Form2(text, row, col, size, mines);
            f.Show();
            gamesOpen.Text = System.Windows.Forms.Application.OpenForms.OfType<Form2>().Count().ToString();


        }

        private void easyMenuStrip_Pressed(object sender, EventArgs e)
        {
            int row = 9, col = 9;
            int mines = 10;
            String text = "Easy";
            Form2 f = null;
            int size = Math.Min(30, 1000 / Math.Max(row, col));
            f = new Form2(text, row, col, size, mines);
            f.Show();
            gamesOpen.Text = System.Windows.Forms.Application.OpenForms.OfType<Form2>().Count().ToString();
        }
        
        private void mediumMenuStrip_Pressed(object sender, EventArgs e)
        {
            int row = 16, col = 16;
            int mines = 40;
            String text = "Medium";
            Form2 f = null;
            int size = Math.Min(30, 1000 / Math.Max(row, col));
            f = new Form2(text, row, col, size, mines);
            f.Show();
            gamesOpen.Text = System.Windows.Forms.Application.OpenForms.OfType<Form2>().Count().ToString();
        }

        private void expertMenuStrip_Pressed(object sender, EventArgs e)
        {
            int row = 30;
            int col = 16;
            int mines = 99;
            String text = "Expert";
            Form2 f = null;
            int size = Math.Min(30, 1000 / Math.Max(row, col));
            f = new Form2(text, row, col, size, mines);
            f.Show();
            gamesOpen.Text = System.Windows.Forms.Application.OpenForms.OfType<Form2>().Count().ToString();
        }

        private void closeGames_pressed(object sender, EventArgs e)
        {
            foreach(Form2 f in System.Windows.Forms.Application.OpenForms.OfType<Form2>().ToList())
            {
                f.Close();
            }
        }

        private void exit_Pressed(object sender, EventArgs e)
        {
            Close();
        }
    }
}
