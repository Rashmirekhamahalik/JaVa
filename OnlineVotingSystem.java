
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OnlineVotingSystem {
    private Map<String, Integer> candidates = new HashMap<>();
    private Map<String, String> voters = new HashMap<>();

    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    public void addVoter(String voterId, String voterName) {
        voters.put(voterId, voterName);
    }

    public void vote(String voterId, String candidateName) {
        if (voters.containsKey(voterId) && candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1);
            System.out.println("Thank you for voting, " + voters.get(voterId) + "!");
        } else {
            System.out.println("Invalid voter ID or candidate name. Please try again.");
        }
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> candidate : candidates.entrySet()) {
            System.out.println(candidate.getKey() + ": " + candidate.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        Scanner scanner = new Scanner(System.in);

        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");
        votingSystem.addCandidate("Candidate C");

        votingSystem.addVoter("12345", "Ratna");
        votingSystem.addVoter("67890", "prava");

        while (true) {
            System.out.println("Online Voting System");
            System.out.println("1. Vote");
            System.out.println("2. Display Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your voter ID: ");
                    String voterId = scanner.nextLine();
                    System.out.print("Enter the candidate name you want to vote for: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.vote(voterId, candidateName);
                    break;

                case 2:
                    votingSystem.displayResults();
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
