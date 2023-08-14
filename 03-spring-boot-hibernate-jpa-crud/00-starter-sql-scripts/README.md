# Setting up MySQL Database

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installing MySQL Database Server](#installing-mysql-database-server)
- [Installing MySQL Workbench](#installing-mysql-workbench)
- [Setting Up Database Table](#setting-up-database-table)
    - [About 01-create-user.sql](#about-01-create-usersql)
    - [About 02-student-tracker.sql](#about-02-student-trackersql)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

In today's digital era, databases form the backbone of almost all major applications and websites. One of the most popular relational database management systems (RDBMS) is MySQL. This guide is designed to provide a comprehensive walkthrough for setting up a MySQL Database, from the basic installation of the MySQL Server to the advanced setup of database tables.

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

## Installing MySQL Workbench

You can install MySQL Workbench using Homebrew by running the following command in the Terminal:

```bash
brew install --cask mysqlworkbench
```

## Setting Up Database Table

Folder: 00-starter-sql-scripts
- 01-create-user.sql
- 02-student-tracker.sql

### About 01-create-user.sql

Create a new MySQL user for our application
- user id: springstudent
- password: springstudent

### About 02-student-tracker.sql

Create a new database table: student

## Conclusion

Setting up a MySQL Database might seem complex at first, but with the right resources and steps, it becomes straightforward. By following this tutorial, users are not only able to install MySQL on their Mac but can also confidently set up a basic database structure, understanding the pivotal role of each SQL script in the process. As with any tech stack, continued exploration and practice will deepen understanding and proficiency. Happy databasing!

## References

- [MySQL Official Documentation](https://dev.mysql.com/doc/)
- [Homebrew Documentation](https://docs.brew.sh/)
- [MySQL Workbench](https://www.mysql.com/products/workbench/)
- [W3Schools MySQL Tutorial](https://www.w3schools.com/sql/)
