package main.java;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Trainee {
    private String name;
    private int points;  // Tracks points earned by the trainee
    private boolean completedMorningTask;
    private boolean completedAfternoonTask;

    // Constructor
    public Trainee(String name) {
        this.name = name;
        this.points = 0;  // Starts with 0 points
        this.completedMorningTask = false;
        this.completedAfternoonTask = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    // Task completion for the morning
    public void completeMorningTask() {
        Random random = new Random();
        completedMorningTask = random.nextBoolean(); // Random task completion
        if (completedMorningTask) {
            points += 10;  // Earn points for completing morning task
        }
    }

    // Task completion for the afternoon
    public void completeAfternoonTask() {
        Random random = new Random();
        completedAfternoonTask = random.nextBoolean(); // Random task completion
        if (completedAfternoonTask) {
            points += 10;  // Earn points for completing afternoon task
        }
    }

    // Print trainee status at the end of the day
    public void printStatus() {
        System.out.println(name + " - Points: " + points + ", Morning Task: " + (completedMorningTask ? "Completed" : "Missed") 
                           + ", Afternoon Task: " + (completedAfternoonTask ? "Completed" : "Missed"));
    }
}

class TrainingDay {
    private List<Trainee> trainees;
    private LocalTime startTime;
    private LocalTime lunchBreakStart;
    private LocalTime lunchBreakEnd;
    private LocalTime endTime;

    // Constructor
    public TrainingDay(int numTrainees) {
        trainees = new ArrayList<>();
        for (int i = 1; i <= numTrainees; i++) {
            trainees.add(new Trainee("Trainee " + i));
        }
        startTime = LocalTime.of(9, 0);  // 9:00 AM
        lunchBreakStart = LocalTime.of(13, 0);  // 1:00 PM
        lunchBreakEnd = LocalTime.of(14, 0);  // 2:00 PM
        endTime = LocalTime.of(17, 0);   // 5:00 PM
    }

    // Display schedule
    public void displaySchedule() {
        System.out.println("Training starts at: " + startTime);
        System.out.println("Lunch break from: " + lunchBreakStart + " to " + lunchBreakEnd);
        System.out.println("Training ends at: " + endTime);
    }

    // Simulate the training day
    public void startTrainingDay() {
        System.out.println("\n*** Training Day Begins ***");

        System.out.println("\n--- Morning Session: Assigning Tasks ---");
        assignMorningTasks();

        System.out.println("\n--- Lunch Break ---");
        System.out.println("All trainees are having lunch.");

        System.out.println("\n--- Afternoon Session: Assigning Tasks ---");
        assignAfternoonTasks();

        System.out.println("\n--- Training Day Ends ---");

        System.out.println("\n*** Final Results ***");
        displayTraineeResults();
    }

    // Assign morning tasks and track completion
    private void assignMorningTasks() {
        System.out.println("Each trainee must complete a morning task.");
        for (Trainee trainee : trainees) {
            trainee.completeMorningTask();
            System.out.println(trainee.getName() + " has " + (trainee.getPoints() > 0 ? "completed" : "not completed") + " the morning task.");
        }
    }

    // Assign afternoon tasks and track completion
    private void assignAfternoonTasks() {
        System.out.println("Each trainee must complete an afternoon task.");
        for (Trainee trainee : trainees) {
            trainee.completeAfternoonTask();
            System.out.println(trainee.getName() + " has " + (trainee.getPoints() > 10 ? "completed" : "not completed") + " the afternoon task.");
        }
    }

    // Display the final results for all trainees
    private void displayTraineeResults() {
        for (Trainee trainee : trainees) {
            trainee.printStatus();
        }

        // Find the top performer
        Trainee topPerformer = trainees.stream()
                .max((t1, t2) -> Integer.compare(t1.getPoints(), t2.getPoints()))
                .orElse(null);

        if (topPerformer != null) {
            System.out.println("\nTop Performer of the Day: " + topPerformer.getName() + " with " + topPerformer.getPoints() + " points!");
        }
    }
}

public class TrainingDaySimulation {
    public static void main(String[] args) {
        // Create a dynamic training session with 30 trainees
        TrainingDay trainingDay = new TrainingDay(30);

        // Display the schedule for the day
        trainingDay.displaySchedule();

        // Start the training day simulation
        trainingDay.startTrainingDay();
    }
}
