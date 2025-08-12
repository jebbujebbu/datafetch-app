# DataFetch App

An Android app that fetches and displays date-name data from a JSON source, demonstrating networking, JSON parsing, and list UI display using both ListView and RecyclerView.

## Features

- Fetches JSON data from a hosted file via GitHub Pages
- Parses JSON array containing dates and names
- Displays data in a list using:
  - Original ListView with a custom adapter
  - Modern RecyclerView with an updated adapter
- Demonstrates networking with Volley library
- Supports edge-to-edge display with padding for system bars

## Installation

1. Clone the repository:

```bash
git clone https://github.com/jebbujebbu/datafetch-app.git
cd datafetch-app
```

2. Open either the ``/app`` folder (original ListView version) or the ``/app-recyclerview`` folder (RecyclerView version) in Android Studio.

3. Build and run the app on an emulator or physical device.

## Usage

The app automatically fetches data from: `https://jebbujebbu.github.io/datafetch-app/data/data.json`.

Ensure GitHub Pages is enabled in your repository settings to serve this JSON file publicly.

## Project Structure

- ``/app``
  Original Android app using ListView.
  This version is my original implementation showcasing basic Android list handling and networking.

- ``/app-recyclerview``
  Enhanced app refactored to use RecyclerView for a modern list UI.
  This demonstrates updated Android development practices with minimal changes from the original code.

- ``/data/data.json``
  JSON data file hosted on GitHub Pages, used as the app’s data source.

## Example JSON Data Format

```json
[
  {
    "pvm": "27.5.2017 12:15:30",
    "nimi": "Matt Damon"
  },
  {
    "pvm": "28.5.2017 08:00:00",
    "nimi": "Emma Watson"
  }
]
```

## About the Creator

I am an IT Engineering student passionate about Android development and data processing.

This project is part of my portfolio, demonstrating practical skills in app development and network data handling.

Feel free to connect or provide feedback!

*Created by Jenni Mikkonen*
