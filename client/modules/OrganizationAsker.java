package laba6.client.modules;

import laba6.client.App;
import laba6.client.validators.*;
import laba6.common.data.Address;
import laba6.common.data.Coordinates;
import laba6.common.data.OrganizationType;
import laba6.common.exeptions.IncorrectInputInScriptException;
import laba6.common.exeptions.InvalidObjectFieldException;
import laba6.common.exeptions.NotInDeclaredLimitsException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class OrganizationAsker {
    private InputHandler inputHandler;
    private boolean fileMode;

    public OrganizationAsker(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        fileMode = false;
    }

    /**
     * Sets marine asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets marine asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Asks a user the organization's name.
     *
     * @return Organization's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                System.out.println("Enter your name:");
                System.out.print(App.SYMBOL2);
                name = inputHandler.readLine().trim();
                if (fileMode) System.out.println(name);
                NameValidator nameValidator = new NameValidator();
                name = nameValidator.validate(name);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println(exception.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (InvalidObjectFieldException e) {
                System.out.println("The name cannot be empty!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * Asks a user the organization's X coordinate.
     *
     * @return Organization's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Integer askX() throws IncorrectInputInScriptException {
        String strX;
        Integer x;
        while (true) {
            try {
                System.out.println("Enter X coordinate > " + Coordinates.MIN_X + ":");
                System.out.print(App.SYMBOL2);
                strX = inputHandler.readLine().trim();
                if (fileMode) System.out.println(strX);
                XCoordinateValidator xCoordinateValidator = new XCoordinateValidator();
                x = xCoordinateValidator.validate(strX);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("X coordinate not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return x;
    }

    /**
     * Asks a user the organization's Y coordinate.
     *
     * @return Organization's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askY() throws IncorrectInputInScriptException {
        String strY;
        double y;
        while (true) {
            try {
                System.out.println("Enter Y coordinate <= " + (Coordinates.MAX_Y) + ":");
                System.out.println(App.SYMBOL2);
                strY = inputHandler.readLine().trim();
                if (fileMode) System.out.println(strY);
                YCoordinateValidator yCoordinateValidator = new YCoordinateValidator();
                y = yCoordinateValidator.validate(strY);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Y coordinate not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return y;
    }

    /**
     * Asks a user the organization's coordinates.
     *
     * @return Organization's coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        Integer x;
        double y;
        x = askX();
        y = askY();
        try {
            return new Coordinates(x, y);
        } catch (InvalidObjectFieldException e) {
            System.out.println(e.getMessage());
            if (fileMode) throw new IncorrectInputInScriptException();
            return null;
        }
    }

    /**
     * Asks a user the organization's annual turnover.
     *
     * @return Organization's annual turnover.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Integer askAnnualTurnover() throws IncorrectInputInScriptException {
        String strAnnualTurnover;
        Integer annualTurnover;
        while (true) {
            try {
                System.out.println("Enter annual turnover/RUB, > 0:");
                System.out.print(App.SYMBOL2);
                strAnnualTurnover = inputHandler.readLine().trim();
                if (fileMode) System.out.println(strAnnualTurnover);
                AnnualTurnoverValidator annualTurnoverValidator = new AnnualTurnoverValidator();
                annualTurnover = annualTurnoverValidator.validate(strAnnualTurnover);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Annual turnover not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return annualTurnover;
    }

    /**
     * Asks a user the organization's employees count.
     *
     * @return Organization's employees count.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Integer askEmployeesCount() throws IncorrectInputInScriptException {
        String strEmployeesCount;
        Integer employeesCount;
        while (true) {
            try {
                System.out.println("Enter annual turnover/RUB, > 0:");
                System.out.print(App.SYMBOL2);
                strEmployeesCount = inputHandler.readLine().trim();
                if (fileMode) System.out.println(strEmployeesCount);
                AnnualTurnoverValidator annualTurnoverValidator = new AnnualTurnoverValidator();
                employeesCount = annualTurnoverValidator.validate(strEmployeesCount);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Health not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return employeesCount;
    }

    /**
     * Asks a user the organization type.
     *
     * @return Organization type.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public OrganizationType askOrganizationType() throws IncorrectInputInScriptException {
        String strOrganizationType;
        OrganizationType organizationType;
        while (true) {
            try {
                System.out.println("Enter organization type:");
                System.out.println(App.SYMBOL2);
                strOrganizationType = inputHandler.readLine().trim();
                OrganizationTypeValidator organizationTypeValidator = new OrganizationTypeValidator();
                organizationType = organizationTypeValidator.validate(strOrganizationType);
                if (fileMode) System.out.println(strOrganizationType);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Weapon not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return organizationType;
    }

    /**
     * Asks a user the organization's zip code.
     *
     * @return Organization's zip code.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Address askZipCode() throws IncorrectInputInScriptException {
        String zipCode;
        Address address;
        while (true) {
            try {
                System.out.println("Enter the melee weapon:");
                System.out.println(App.SYMBOL2);
                zipCode = inputHandler.readLine().trim();
                if (fileMode) System.out.println(zipCode);
                ZipCodeValidator zipCodeValidator = new ZipCodeValidator();
                address = zipCodeValidator.validate(zipCode);
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Weapon not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                System.out.println("Unexpected error!");
                System.exit(0);
            } catch (InvalidObjectFieldException e) {
                System.out.println(e.getMessage());
                if (fileMode) throw new IncorrectInputInScriptException();
            }
        }
        return address;
    }
}
