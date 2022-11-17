using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace COP4226_Assignment5_Snake
{
    public partial class MainForm : Form
    {
        private Form2 f2;
        private int Step = 1;
        private readonly SnakeGame Game;
        private int NumberOfApples = 1;
        internal Boolean is_paused, is_becoming_transparent;
        internal int alpha = 0;
        internal Color appleColor;
        public MainForm()
        {
            InitializeComponent();
            alpha = 255;
            is_becoming_transparent = true;
            mainTimer.Enabled = false;
            toolStripProgressBar1.Value = 10;
            f2 = new Form2();
            DialogResult res = f2.ShowDialog();
            if (res == DialogResult.OK)
            {
                mainTimer.Enabled = true;
                NumberOfApples = f2.number_of_apples;
                Game = new SnakeGame(new System.Drawing.Point((Field.Width - 20) / 2, Field.Height / 2), 40, NumberOfApples, Field.Size);
                Field.Image = new Bitmap(Field.Width, Field.Height - 25);
                Game.EatAndGrow += Game_EatAndGrow;
                Game.HitWallAndLose += Game_HitWallAndLose;
                Game.HitSnakeAndLose += Game_HitSnakeAndLose;
            }

        }

        private void Game_HitWallAndLose()
        {
            mainTimer.Stop();
            Field.Refresh();
        }
        private void Game_HitSnakeAndLose()
        {
            mainTimer.Stop();
            Field.Refresh();
        }
        private void Game_EatAndGrow()
        {
            toolStripLabel2.Text = "Apples Eaten:" + Game.apples_eaten;
            if (Step < 10)
            {
                Step += Game.apples_eaten % 10 == 0 ? 1 : 0;
                Console.WriteLine("Snake Speed:" + Step);
                toolStripProgressBar1.Value = Step < 10 ? Step * 10 : 100;
                toolStripLabel1.Text = "Snake Speed:" + Step;
            }
        }
        private void MainTimer_Tick(object sender, EventArgs e)
        {
            if (alpha > 100 && is_becoming_transparent)
            {
                appleColor = Color.FromArgb(alpha -= 2, 250, 50, 50);
                is_becoming_transparent = alpha > 100;
            }
            else if (alpha < 255 && !is_becoming_transparent)
            {
                appleColor = Color.FromArgb(alpha += 2, 250, 50, 50);
                is_becoming_transparent = alpha == 255;
            }

            Game.Move(Step);
            Field.Invalidate();
        }
        private void Field_Paint(object sender, PaintEventArgs e)
        {
            Pen PenForObstacles = new Pen(Color.FromArgb(40, 40, 40), 2);
            Pen PenForSnake = new Pen(Color.FromArgb(100, 100, 100), 2);
            Brush BackGroundBrush = new SolidBrush(Color.FromArgb(150, 250, 150));
            Brush AppleBrush = new SolidBrush(appleColor);

            using (Graphics g = Graphics.FromImage(Field.Image))
            {
                g.FillRectangle(BackGroundBrush, new Rectangle(0, 0, Field.Width, Field.Height));
                foreach (Point Apple in Game.Apples)
                    g.FillEllipse(AppleBrush, new Rectangle(Apple.X - SnakeGame.AppleSize / 2, Apple.Y - SnakeGame.AppleSize / 2,
                        SnakeGame.AppleSize, SnakeGame.AppleSize));
                foreach (LineSeg Obstacle in Game.Obstacles)
                    g.DrawLine(PenForObstacles, new System.Drawing.Point(Obstacle.Start.X, Obstacle.Start.Y)
                        , new System.Drawing.Point(Obstacle.End.X, Obstacle.End.Y));
                foreach (LineSeg Body in Game.SnakeBody)
                    g.DrawLine(PenForSnake, new System.Drawing.Point((int)Body.Start.X, (int)Body.Start.Y)
                        , new System.Drawing.Point((int)Body.End.X, (int)Body.End.Y));
            }
        }
        private void Snakes_KeyDown(object sender, KeyEventArgs e)
        {
            switch (e.KeyCode)
            {
                case Keys.Up:
                    Game.Move(Step, Direction.UP);
                    break;
                case Keys.Down:
                    Game.Move(Step, Direction.DOWN);
                    break;
                case Keys.Left:
                    Game.Move(Step, Direction.LEFT);
                    break;
                case Keys.Right:
                    Game.Move(Step, Direction.RIGHT);
                    break;
            }
        }



        private void Field_Click(object sender, EventArgs e)
        {
            if (!is_paused)
            {
                mainTimer.Stop();
                is_paused = true;
            }
            else
            {
                mainTimer.Start();
                is_paused = false;
            }

        }

    }
}
