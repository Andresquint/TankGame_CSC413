/* TankGame
Created By: Stephanie Sechrist
Last Edited: April 15, 2019

To make this game, I followed along with a YouTube tutorial made by CodeNMore.
The series is called "New Beginner 2D Game Programming" and a lot of my program
structure comes from following along with him. In addition, my tank control was largely
taken from Souza's TRE he provided on iLearn.

The rest of the code is severely lacking in comments, as I pretty much ran out of time and prioritized
getting requirements done over comments. Sorry if the structure is hard to follow. There's a lot going on,
I'll definitely put many comments if I reuse this code for the second game!
 */

package dev.tankgame;


public class Launcher {
    public static void main(String[] args){
        Game game = new Game("Tank Game", 1280, 800);
        game.start();
    }
}
