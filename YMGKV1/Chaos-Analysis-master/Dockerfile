# Base image with Python 3.10
FROM python:3.10

# Set working directory
WORKDIR /app

# Copy the project files from the host into the container
COPY . /app/

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Expose port
EXPOSE 8000

# Run the application
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
