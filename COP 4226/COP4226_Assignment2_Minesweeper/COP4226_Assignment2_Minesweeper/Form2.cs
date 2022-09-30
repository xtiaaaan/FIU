using COP4226_Assignment2_Minesweeper;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics.Tracing;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Security.AccessControl;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;

namespace COP4226_Assignment2_Minesweeper
{
    public partial class Form2 : Form
    {
        private int time = 0;
        private int flags = 0;
        public Form2()
        {
            InitializeComponent();
        }
        public Form2(String text, int row, int col, int size, int mines) : this()
        {
            flags = mines;
            flagsLabel.Text = flags.ToString();
            this.Text = text;
            field = new Field(row, col, mines);
            this.ClientSize = new Size(row * size, col * size + 50);
            buttons = new Button[row][];
            for (int i = 0; i < row; i++)
                buttons[i] = new Button[col];
            foreach (int i in Enumerable.Range(0, row))
                foreach (int j in Enumerable.Range(0, col))
                {
                    buttons[i][j] = new Button();
                    buttons[i][j].Text = "";
                    buttons[i][j].BackColor = Color.White;
                    buttons[i][j].Name = i + "," + j;
                    buttons[i][j].Size = new Size(size, size);
                    buttons[i][j].Location = new Point(size * i, size * j + 50);
                    buttons[i][j].UseVisualStyleBackColor = false;
                    buttons[i][j].MouseUp += new MouseEventHandler(Button_Click);
                    this.Controls.Add(buttons[i][j]);
                }
        }
        private void Button_Click(object sender, MouseEventArgs e)
        {
            Button b = (Button)sender;
            int temp = b.Name.IndexOf(",");
            int click_x = Int16.Parse(b.Name.Substring(0, temp));
            int click_y = Int16.Parse(b.Name.Substring(temp + 1));

            switch (e.Button)
            {
                case MouseButtons.Left:
                    // Left click
                    timer1.Enabled = true;
                    timer1.Start();
                    if (!this.field.Started)
                        this.field.Initialize(click_x, click_y);
                    int n = this.field.CountMines(click_x, click_y);
                    if (this.field.IsMine(click_x, click_y))
                    {
                        b.BackColor = Color.Red;
                        timer1.Stop();
                        MessageBox.Show("Game Over! You clicked on a mine!");
                        break;
                    }
                    if (this.field.Discovered.Contains(click_x * buttons[0].Length + click_y))
                        break;
                    foreach (int k in this.field.GetSafeIsland(click_x, click_y))
                    {
                        int i = k / buttons[0].Length;
                        int j = k % buttons[0].Length;
                        buttons[i][j].BackColor = Color.LightGray;
                        int m = this.field.CountMines(i, j);
                        if (m > 0)
                        {
                            buttons[i][j].Text = m + "";
                            buttons[i][j].BackColor = Color.LightBlue;
                        }
                        else
                            buttons[i][j].Enabled = false;
                    }
                    if (field.Win())
                    {
                        timer1.Stop();
                        MessageBox.Show("Congratulations! You discovered all safe squares!\n" +
                                "You won in " + time + " seconds!");
                    }
                    break;
                case MouseButtons.Right:
                    // Right click
                    timer1.Enabled = true;
                    timer1.Start();
                    if (this.field.Discovered.Contains(click_x * buttons[0].Length + click_y))
                        break;
                    if (field.Flagged.Contains(click_x * buttons[0].Length + click_y))
                    {
                        flags++;
                        flagsLabel.Text = flags.ToString();
                        b.BackColor = Color.White;
                        field.Flagged.Remove(click_x * buttons[0].Length + click_y);
                    }
                    else
                    {
                        flags--;
                        flagsLabel.Text = flags.ToString();
                        b.BackColor = Color.Green;
                        field.Flagged.Add(click_x * buttons[0].Length + click_y);
                    }
                    break;
                case MouseButtons.Middle:
                    // Middle click
                    timer1.Enabled = true;
                    timer1.Start();
                    if (!this.field.Discovered.Contains(click_x * buttons[0].Length + click_y))
                        break;
                    int Flagged_Count = 0;
                    foreach (int k in this.field.GetNeighbors(click_x, click_y))
                        if (field.Flagged.Contains(k))
                            Flagged_Count++;
                    if (this.field.CountMines(click_x, click_y) != Flagged_Count)
                        break;
                    foreach (int k in this.field.GetNeighbors(click_x, click_y))
                    {
                        if (field.Flagged.Contains(k) || field.Discovered.Contains(k))
                            continue;
                        if (this.field.IsMine(k / buttons[0].Length, k % buttons[0].Length))
                        {
                            b.BackColor = Color.Red;
                            timer1.Stop();
                            MessageBox.Show("Game Over! You clicked on a mine!");
                            break;
                        }
                        foreach (int l in this.field.GetSafeIsland(k / buttons[0].Length, k % buttons[0].Length))
                        {
                            int i = l / buttons[0].Length;
                            int j = l % buttons[0].Length;
                            buttons[i][j].BackColor = Color.LightGray;
                            int m = this.field.CountMines(i, j);
                            if (m > 0)
                            {
                                buttons[i][j].Text = m + "";
                                buttons[i][j].BackColor = Color.LightBlue;
                            }
                            else
                                buttons[i][j].Enabled = false;
                        }
                        if (field.Win())
                        {
                            timer1.Stop();
                            MessageBox.Show("Congratulations! You discovered all safe squares!\n" +
                                "You won in " + time + " seconds!");
                        }
                    } 
                    break;
            }


        }

        private Button[][] buttons;
        private Field field;

        private void timer1_Tick(object sender, EventArgs e)
        {
            time++;
            timerLabel.Text = time.ToString();
        }

        private void form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (MessageBox.Show("Are you sure you want to close the game?", "Closing Game", MessageBoxButtons.YesNo) != DialogResult.Yes)
            {
                e.Cancel = true;
            }
        }
        private void deactivtedForm(object sender, EventArgs e)
        {
            timer1.Stop();
        }
    }
}
