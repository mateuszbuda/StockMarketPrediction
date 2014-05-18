StockMarketPrediction
=====================

Expert system for predicting stock market timing using a candlestick chart.


Dependencies:
In order to complie this project, opencsv project is required on the build path.

You can download it from here:
http://sourceforge.net/projects/opencsv/

Then import it to your workspace and simply add to build path.


Input data format:
In java applet you load input data from a file.
It must contain data that meets following demands.

1. Each row contains values in format:
open_price,high_price,low_price,close_price
2. File contains at least 6 rows.
3. Rows are sorted by date so that the most recent stock prices are in the first row.
4. Prices are decimals with decimal point '.' and wihout currency symbol.

You can find example file in the repository [example_data.csv].

You can generate similar file from this site:
http://finance.yahoo.com/stock-center/

Just select company, go to Historical Prices, scroll down the site and download spreadsheet.
Then remember to remove unnecessary columns.
