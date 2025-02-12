# VerseDecode

VerseDecode is a Spring Boot application that provides deep, AI-powered analysis of song lyrics using OpenAI's GPT model. It helps users understand the deeper meaning, themes, and interpretations of their favorite songs.

## Features

- Song analysis using OpenAI's GPT model
- Detailed interpretation of lyrics, themes, and cultural significance
- RESTful API endpoints for song analysis
- Cross-origin support for frontend integration

## Tech Stack

- Java 17
- Spring Boot 3.4.1
- OpenAI GPT-3.5 Turbo
- H2 Database
- Maven

## API Endpoints

### Analyze Song
GET /api/songs/analyze?title={title}&artist={artist}

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `title` | `string` | **Required**. Title of the song |
| `artist` | `string` | **Required**. Name of the artist |

## Setup

1. Clone the repository
git clone https://github.com/YOUR-USERNAME/versedecoded.git

2. Create a `.env` file in the project root with your OpenAI API key:
OPENAI_API_KEY=your-api-key-here

3. Build the project
mvn clean install

4. Run the application
mvn spring-boot:run

The application will be available at `http://localhost:8080`

## Environment Variables

- `OPENAI_API_KEY` - Your OpenAI API key

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
