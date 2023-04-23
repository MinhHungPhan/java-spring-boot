## Prerequisites

Before we begin, you will need the following:

- Install MySQL Database Server
- Install MySQL Workbench
- Set Up Database Table

## Installing MySQL Database Server

Here are the steps to install MySQL Database Server on your Mac using Homebrew:

1. Open Terminal on your Mac. You can do this by searching for Terminal in the Spotlight search or by going to Applications > Utilities > Terminal.

2. Install Homebrew by entering the following command in the Terminal:

  ```bash
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  ```
3. Once Homebrew is installed, update it to make sure you have the latest version by running the following command:

  ```bash
  brew update
 ```
4. Install MySQL using Homebrew by running the following command:

  ```bash
  brew install mysql
  ```
5. After the installation is complete, start the MySQL server by running the following command:

  ```bash
  mysql.server start
  ```
6. To set up a root password for MySQL, run the following command:

  ```bash
  mysql_secure_installation
  ```
Follow the prompts to set up a root password and secure the installation.

7. Verify that MySQL is running by entering the following command:

  ```bash
  mysqladmin -u root -p version
  ```
Enter the root password you set up earlier when prompted.

You should now have MySQL installed and running on your Mac using Homebrew.

## Install MySQL Workbench

You can install MySQL Workbench using Homebrew by running the following command in the Terminal:

  ```bash
  brew install --cask mysqlworkbench
  ```

## Setting Up Database Table

1. Folder: 00-starter-sql-scripts
- 01-create-user.sql
- 02-student-tracker.sql

### About 01-create-user.sql

1. Create a new MySQL user for our application
- user id: springstudent
- password: springstudent

### About 02-student-tracker.sql
1. Create a new database table: student
