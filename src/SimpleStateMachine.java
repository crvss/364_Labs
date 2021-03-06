import java.util.Scanner;

//  S0 - hugo   / on    -> S1
//  S1 - erna   / off   -> S2
//  S2 -        / blink -> S0
//  S2 - alfred /       -> S1

public class SimpleStateMachine
{

	public enum State
	{
		S0, S1, S2;
	}

	public static void main(String args[])
	{

		// set initial state
		State currentState = State.S0;

		Scanner input = new Scanner(System.in);

		while (true)
		{
			// write current state on the screen
			// used only for debugging
			// System.out.println("the current state is " + currentState);

			// read input
			System.out.print("your input: ");
			String currentInput = input.nextLine();

			// take the transition
			switch (currentState)
			{
				case S0:
					// only one transition starts at S0
					// S0 - hugo / on -> S1

					// UML semantics: any input different from "hugo"
					// is to be ignored, i.e., we stay in state S0

					switch (currentInput)
					{
						case "hugo":
							System.out.println("Output: on");
							currentState = State.S1;
							break;
					}
					break;

				case S1:
					// only one transition starts at S1
					// S1 - erna / off -> S2

					// UML semantics: any input different from "hugo"
					// is to be ignored, i.e., we stay in state S1

					switch (currentInput)
					{
						case "erna":
							System.out.println("Output: off");
							currentState = State.S2;
							break;
					}
					break;

				case S2:
					// two transitions start at S2
					// S2 - / blink -> S0
					// S2 - alfred / -> S1

					// UML semantics: any input different from "" and
					// "alfred"
					// are to be ignored, i.e., we stay in state S2

					switch (currentInput)
					{
						case "alfred":
							currentState = State.S0;
							break;
						case "":
							currentState = State.S1;
							System.out.println("Output: blink");
							break;
					}

			}
		}
	}
}