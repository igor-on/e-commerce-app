# E-Commerce Full Stack Application

A modern, full-stack e-commerce application built with **Angular** frontend and **Spring Boot** backend, featuring secure authentication, payment processing, and comprehensive order management.

## 🏗️ Architecture Overview

This application follows a modern microservices architecture pattern with:

- **Frontend**: Angular 10 SPA (Single Page Application)
- **Backend**: Spring Boot 2.4.0 REST API
- **Database**: MySQL 8
- **Authentication**: Okta OAuth2/OpenID Connect
- **Payments**: Stripe Integration
- **Security**: HTTPS/SSL, CORS configuration

## 🛠️ Technologies Stack

### Backend (Spring Boot)
- **Framework**: Spring Boot 2.4.0
- **Java Version**: 13
- **Database**: MySQL with JPA/Hibernate
- **Security**: Spring Security + Okta OAuth2
- **Payment Processing**: Stripe API
- **Data Access**: Spring Data JPA, Spring Data REST
- **Build Tool**: Maven

### Frontend (Angular)
- **Framework**: Angular 10
- **UI Components**: Bootstrap 4, ng-bootstrap
- **Icons**: FontAwesome
- **Authentication**: Okta Angular SDK
- **HTTP Client**: Angular HttpClient with Interceptors
- **Styling**: CSS3, Bootstrap responsive design
- **Development**: TypeScript, SSL-enabled development server

### Dependencies & Libraries

#### Backend Dependencies
```xml
- Spring Boot Starter Data JPA
- Spring Boot Starter Data REST  
- Spring Boot Starter Web
- MySQL Connector
- Okta Spring Boot Starter
- Stripe Java SDK
- Lombok (for reducing boilerplate code)
```

#### Frontend Dependencies
```json
- Angular Core, Router, Forms, Animations
- ng-bootstrap for UI components
- Okta Angular for authentication
- Stripe for payment processing
- Bootstrap for responsive design
- FontAwesome for icons
```

## 🏪 Application Features

### 🛍️ Core E-commerce Features
- **Product Catalog**: Browse products by categories with pagination
- **Product Search**: Search products by name with real-time filtering
- **Product Details**: Detailed product information with images
- **Shopping Cart**: Add/remove items, quantity management, persistent cart
- **Checkout Process**: Multi-step checkout with form validation
- **Order Management**: Order history and tracking

### 🔐 Authentication & Security
- **OAuth2 Authentication**: Secure login via Okta
- **Protected Routes**: Route guards for authenticated users
- **JWT Token Management**: Automatic token refresh and validation
- **HTTPS/SSL**: Secure communication between client and server
- **CORS Configuration**: Properly configured cross-origin requests

### 💳 Payment Processing
- **Stripe Integration**: Secure payment processing
- **Payment Intent API**: Modern payment flow with 3D Secure support
- **Multiple Payment Methods**: Support for various payment types

### 📱 User Experience
- **Responsive Design**: Mobile-first, responsive UI
- **Real-time Updates**: Cart status updates, inventory management
- **Form Validation**: Client and server-side validation
- **Error Handling**: Comprehensive error handling and user feedback

## 📊 Database Schema

The application uses the following main entities:

- **Product**: Product information (name, price, description, images, stock)
- **ProductCategory**: Product categorization
- **Customer**: User account information
- **Order**: Order header information
- **OrderItem**: Individual items within an order
- **Address**: Shipping and billing addresses
- **Country/State**: Geographic data for address forms

## 🔄 Application Flow

### 1. Product Browsing
```
User visits site → Product list loads → Filter by category/search → View product details
```

### 2. Shopping & Checkout
```
Add to cart → Review cart → Proceed to checkout → Login (if required) → Enter shipping info → Payment → Order confirmation
```

### 3. Order Management
```
Login → View order history → Track orders → Order details
```

## 🚀 Getting Started

### Prerequisites
- **Java 13+**
- **Node.js 12+** and npm
- **MySQL 8.0+**
- **Maven 3.6+**
- **Okta Developer Account** (for authentication)
- **Stripe Account** (for payments)

### Backend Setup

1. **Database Configuration**
   ```bash
   # Create MySQL database
   mysql -u root -p
   CREATE DATABASE full-stack-ecommerce;
   CREATE USER 'ecommerceapp'@'localhost' IDENTIFIED BY 'ecommerceapp';
   GRANT ALL PRIVILEGES ON full_stack_ecommerce.* TO 'ecommerceapp'@'localhost';
   ```

2. **Configure Application Properties**
   ```properties
   # Update src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/full-stack-ecommerce
   spring.datasource.username=ecommerceapp
   spring.datasource.password=ecommerceapp
   
   # Add your Okta credentials
   okta.oauth2.client-id=YOUR_CLIENT_ID
   okta.oauth2.client-secret=YOUR_CLIENT_SECRET
   okta.oauth2.issuer=https://YOUR_DEV_DOMAIN/oauth2/default
   
   # Add your Stripe secret key
   stripe.key.secret=YOUR_STRIPE_SECRET_KEY
   ```

3. **Run Spring Boot Application**
   ```bash
   cd 02-backend/spring-boot-ecommerce
   ./mvnw spring-boot:run
   ```

### Frontend Setup

1. **Install Dependencies**
   ```bash
   cd 03-frontend/angular-ecommerce
   npm install
   ```

2. **Configure Okta Settings**
   ```typescript
   // Update src/app/config/my-app-config.ts
   export default {
       oidc: {
           clientId: 'YOUR_OKTA_CLIENT_ID',
           issuer: 'https://YOUR_DEV_DOMAIN/oauth2/default',
           redirectUri: 'https://localhost:4200/login/callback',
           scopes: ['openid', 'profile', 'email']
       }
   }
   ```

3. **Start Development Server**
   ```bash
   npm start
   # Runs on https://localhost:4200 with SSL
   ```

## 🌐 API Endpoints

### REST API Base URL: `https://localhost:8443/api`

#### Product Management
- `GET /api/products` - Get all products (paginated)
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/search/findByCategoryId?id={categoryId}` - Get products by category
- `GET /api/products/search/findByNameContaining?name={keyword}` - Search products

#### Category Management
- `GET /api/product-category` - Get all categories

#### Geography
- `GET /api/countries` - Get all countries
- `GET /api/states/search/findByCountryCode?code={countryCode}` - Get states by country

#### Checkout & Orders
- `POST /api/checkout/purchase` - Place an order
- `POST /api/checkout/payment-intent` - Create Stripe payment intent
- `GET /api/orders/search/findByCustomerEmailOrderByDateCreatedDesc` - Get order history

## 🔒 Security Features

- **HTTPS Everywhere**: Both frontend and backend use SSL/TLS
- **OAuth2 Authentication**: Industry-standard authentication flow
- **JWT Tokens**: Secure token-based authentication
- **CORS Protection**: Properly configured cross-origin resource sharing
- **Input Validation**: Server-side validation for all inputs
- **SQL Injection Prevention**: JPA/Hibernate parameterized queries

## 📱 Responsive Design

The application is fully responsive and optimized for:
- **Desktop**: Full-featured experience
- **Tablet**: Optimized layout and navigation
- **Mobile**: Touch-friendly interface with simplified navigation

## 🧪 Testing

The application includes:
- **Unit Tests**: Spring Boot test classes
- **Integration Tests**: End-to-end testing setup
- **Angular Testing**: Karma and Jasmine test framework

## 📦 Deployment

### Production Build

**Frontend:**
```bash
ng build --prod
```

**Backend:**
```bash
./mvnw clean package
```

### Environment Configuration

The application supports multiple environments:
- **Development** (`application.properties`)
- **QA** (`application-qa.properties`)
- **Production** (environment variables)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Development Team

Built as a learning project demonstrating modern full-stack development practices with enterprise-grade technologies and security features.

---

*This e-commerce application showcases modern web development practices including microservices architecture, OAuth2 security, payment processing, and responsive design.*
