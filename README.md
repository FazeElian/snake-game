# 🐍 Snake Game

An implementation of the classic **Snake** game in Java with Swing, developed in **BlueJ** and organized into two layers: `domain` (game rules) and `presentation` (graphical user interface).

## Game description

The player controls a snake that moves on its own across a grid of cells. Before each game, the player chooses how many fruits will be on the board, and that amount stays fixed for the whole game: every time the snake eats a fruit, a new one appears in a random free cell. The goal is to eat as many fruits as possible: every time the snake eats, it grows by one segment, the player earns points, and the game gets a little faster. The game ends when the snake's head hits the edge of the board or its own body.

### Controls

| Key | Action |
|---|---|
| ↑ ↓ ← → (or W A S D) | Change the snake's direction |
| Space | Pause / resume |
| N | New game (asks for the number of fruits) |

## Functional requirements

| ID | Requirement |
|---|---|
| FR01 | The game takes place on a rectangular grid of cells (30 × 30 by default). |
| FR02 | The snake starts with 3 segments, at the center-left of the board, moving to the right. |
| FR03 | The snake automatically moves one cell per turn in its current direction. |
| FR04 | The player changes direction with the arrow keys (and optionally W, A, S, D). |
| FR05 | The snake cannot reverse its direction directly (if it is moving right, it cannot turn left on the next turn). |
| FR06 | Only one direction change is accepted per turn, so the snake cannot bite itself when two keys are pressed very quickly. |
| FR07 | Before starting a game, the player chooses the number of fruits on the board (between 1 and 10, default 1). |
| FR08 | The chosen number of fruits is validated: values outside the allowed range are rejected and the player is asked again. |
| FR09 | At the start of the game, all the chosen fruits are placed on random free cells; two fruits never share a cell, and no fruit is placed on the snake. |
| FR10 | The number of fruits on the board stays constant: when the snake eats a fruit, a new one appears immediately on a random free cell. |
| FR11 | If there are fewer free cells than the chosen number of fruits, only as many fruits as fit are placed. |
| FR12 | When the snake eats a fruit, it grows by one segment and the player earns 10 points. |
| FR13 | The game ends if the head collides with an edge or with the snake's own body. |
| FR14 | The speed increases every certain number of fruits eaten (for example, every 5), up to a limit. |
| FR15 | The player can pause and resume the game with the space bar. |
| FR16 | The player can start a new game from the menu or with the N key; the number of fruits is asked again, suggesting the previous value. |
| FR17 | The score, length, number of fruits, and game state (playing, paused, game over) are displayed at all times. |
| FR18 | When the game ends, a message shows the final score and the option to play again. |
| FR19 | The best score of the session is kept. |

## Architecture

```
snake/
├── domain/          ← game rules (plain Java, no Swing)
├── presentation/    ← window, drawing, keyboard and timer (Swing)
└── docs/
    └── snake-demo.gif
```

Dependencies go in one direction only: `presentation → domain`. The `domain` package does not import anything from `javax.swing` or `java.awt`, so it can be tested without opening any window.

Requires Java 8 or later.