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

---

## Solution Overview

The solution simulates Abhimanyu's journey through the Chakravyuha, handling battles, skips, recharges, and enemy regeneration.

### Algorithm:
1. **Input**:
    - Abhimanyu's starting power (`p`).
    - The number of skips (`a`) and recharges (`b`).
    - Enemy power levels in each circle (`k1` to `k11`).

2. **Simulation**:
    - For each circle:
      - The enemy can regenerate (for `k3` and `k7`).
      - If Abhimanyu's power is greater than or equal to the enemy's power, he fights and loses power.
      - If not, Abhimanyu can either skip the battle or recharge (if skips or recharges are available).
    - If Abhimanyu's power is lower than the enemy's after skipping and recharging options are exhausted, he loses the battle.

3. **Result**:
    - If Abhimanyu crosses all 11 circles, the program outputs success.
    - Otherwise, it outputs failure.

---

## Example Test Cases

### Test Case 1:

**Input:**
- Abhimanyu's starting power (`p`): 150
- Number of skips (`a`): 2
- Number of recharges (`b`): 2
- Enemy power levels in circles: `[30, 20, 50, 40, 25, 60, 35, 45, 50, 55, 65]`
- After updating and adding the enemy regeneration power of k3 and k7 to k4 and k8. Final circle powers : `[30, 20, 50, 65, 25, 60, 35, 63, 50, 55, 65]`
- Skip power array: `[65, 65]`

**Output:**

- Abhimanyu fights and wins Circle 1 (power 30).
- Abhimanyu fights and wins Circle 2 (power 20).
- Abhimanyu fights and wins Circle 3 (power 50).
- Abhimanyu skips Circle 4 (power 40).
- Abhimanyu fights and wins Circle 5 (power 25).
- Abhimanyu recharges before Circle 6, power becomes 150.
- Abhimanyu fights and wins Circle 6 (power 60).
- Abhimanyu fights and wins Circle 7 (power 35).
- Abhimanyu recharges before Circle 8, power becomes 150.
- Abhimanyu fights and wins Circle 8 (power 45).
- Abhimanyu fights and wins Circle 9 (power 50).
- Abhimanyu skips Circle 10 (power 55).
- Abhimanyu fights but loses at Circle 11 (power 65).

**Result:** Abhimanyu fails to cross the Chakravyuha.

---

### Test Case 2 :

**Input:**
- Abhimanyu's starting power (`p`): 150
- Number of skips (`a`): 2
- Number of recharges (`b`): 2
- Enemy power levels in circles: `[30, 20, 50, 40, 25, 60, 35, 45, 50, 55, 25]`
- After updating and adding the enemy regeneration power of k3 and k7 to k4 and k8. Final circle powers : `[30, 20, 50, 65, 25, 60, 35, 63, 50, 55, 25]`
- Skip power array: `[65, 63]`

**Output:**

1. **Circle 1 (Power: 30)**: Abhimanyu fights.
   - Remaining power: `150 - 30 = 120`

2. **Circle 2 (Power: 20)**: Abhimanyu fights.
   - Remaining power: `120 - 20 = 100`

3. **Circle 3 (Power: 50)**: Abhimanyu fights.
   - Remaining power: `100 - 50 = 50`

4. **Circle 4 (Power: 65)**: Abhimanyu skips (1/2 skips used).

5. **Circle 5 (Power: 25)**: Abhimanyu fights.
   - Remaining power: `50 - 25 = 25`

6. **Recharge 1**: Abhimanyu recharges before Circle 6.
   - Recharged power: 150

7. **Circle 6 (Power: 60)**: Abhimanyu fights.
   - Remaining power: `150 - 60 = 90`

8. **Circle 7 (Power: 35)**: Abhimanyu fights.
   - Remaining power: `90 - 35 = 55`

9. **Circle 8 (Power: 63)**: Abhimanyu skips (2/2 skips used).

11. **Circle 9 (Power: 50)**: Abhimanyu fights.
    - Remaining power: `55 - 50 = 5`

12. **Recharge 2**: Abhimanyu recharges before Circle 10.
   - Recharged power: 150

13. **Circle 10 (Power: 150)**: Abhimanyu fights.
   - Remaining power: `150 - 55 = 95`

14. **Circle 11 (Power: 25)**: Abhimanyu fights.
    - Remaining power: `95 - 25 = 70`

**Result:** Abhimanyu successfully crosses the Chakravyuha.

---

### Conclusion

In the first test case, Abhimanyu fails to cross the Chakravyuha due to insufficient power against the last circle enemy. However, in the second test case, he successfully crosses all circles, showcasing the effect of strategic skips and recharges.

---
