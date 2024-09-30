# Abhimanyu in Chakravyuha

## Problem Description

Abhimanyu is stuck in the Chakravyuha surrounded by 11 enemy-guarded circles. He needs to cross all the circles to reach the Pandavas' army. Each circle is guarded by enemies with varying power levels. Abhimanyu starts from the innermost circle with a certain amount of power and has special abilities to skip a certain number of enemies and recharge his power a certain number of times.

### Key Details:
- There are 11 circles, each guarded by enemies with power levels: `k1, k2, k3, ..., k11`.
- Abhimanyu starts with `p` power.
- Abhimanyu can **skip fighting** `a` enemies in total.
- Abhimanyu can **recharge his power** `b` times.
- Battling in each circle reduces Abhimanyu's power by the enemy's power level.
- If Abhimanyu enters a circle with power less than the enemy's power, he will lose the battle and fail to cross the Chakravyuha.
- **k3** and **k7** enemies have the ability to regenerate once with half their initial power and attack from behind when Abhimanyu is fighting in the next circle.

### Objective:
Determine if Abhimanyu can cross all the 11 circles and survive.

## Solution Overview

The solution is implemented in Java. The program simulates Abhimanyu's journey through the Chakravyuha, handling battles, skips, recharges, and enemy regeneration.

### Algorithm:
1. **Input**:
    - Abhimanyu's starting power (`p`).
    - The number of skips (`a`) and recharges (`b`).
    - Enemy power levels in each circle (`k1` to `k11`).

2. **Simulation**:
    - For each circle:
      - Check if the enemy can regenerate (for `k3` and `k7`).
      - If Abhimanyu's power is greater than or equal to the enemy's power, he fights and loses power.
      - If not, Abhimanyu can either skip the battle or recharge (if skips or recharges are available).
    - If Abhimanyu's power is lower than the enemy's after skipping and recharging options are exhausted, he loses the battle.

3. **Result**:
    - If Abhimanyu crosses all 11 circles, the program outputs success.
    - Otherwise, it outputs failure.

## Example Test
