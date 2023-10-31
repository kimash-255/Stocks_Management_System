import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Recipe {
    private String recipeName;
    private List<String> ingredients;

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
        ingredients = new ArrayList<>();
    }

    public String getRecipeName() {
        return recipeName;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(String ingredient) {
        ingredients.remove(ingredient);
    }
}

class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public List<Recipe> listRecipes() {
        return new ArrayList<>(recipes);
    }
}

public class RecipeManagementModule {
    public static void run(Scanner scanner) {
        RecipeManager recipeManager = new RecipeManager();

        boolean running = true;
        while (running) {
            System.out.println("Recipe Management Menu");
            System.out.println("1. Add Recipe");
            System.out.println("2. Remove Recipe");
            System.out.println("3. List Recipes");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter recipe name: ");
                    String name = scanner.nextLine();
                    Recipe recipe = new Recipe(name);
                    recipeManager.addRecipe(recipe);
                    System.out.println("Recipe added.");
                    break;
                case 2:
                    System.out.print("Enter recipe name to remove: ");
                    String recipeNameToRemove = scanner.nextLine();
                    Recipe recipeToRemove = recipeManager.listRecipes().stream()
                            .filter(r -> r.getRecipeName().equals(recipeNameToRemove))
                            .findFirst()
                            .orElse(null);

                    if (recipeToRemove != null) {
                        recipeManager.removeRecipe(recipeToRemove);
                        System.out.println("Recipe removed.");
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;
                case 3:
                    List<Recipe> recipes = recipeManager.listRecipes();
                    if (recipes.isEmpty()) {
                        System.out.println("No recipes found.");
                    } else {
                        System.out.println("Recipes:");
                        for (Recipe r : recipes) {
                            System.out.println("Recipe: " + r.getRecipeName());
                            List<String> ingredients = r.getIngredients();
                            if (ingredients.isEmpty()) {
                                System.out.println("No ingredients.");
                            } else {
                                System.out.println("Ingredients:");
                                for (String ingredient : ingredients) {
                                    System.out.println(ingredient);
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}
