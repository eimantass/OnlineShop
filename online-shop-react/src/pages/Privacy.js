import Categories from "../components/categories-menu";
import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Privacy() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('privacy')}</h1>
        <h1>Privacy statement ThisPageGroup</h1>
        <h3>In our servers only the data that is essential for purchases and customer services is collected.
          </h3>
        <h1>What data do we collect?</h1>
        <h3>
        When you order at our website we need data to make sure we can, for instance, complete the payment correctly and ship your package to the right address.
        Or if we need to reach you if something goes wrong with your order. We also collect cookies, but more about that later.
        </h3>
<h3>These are the personal data we collect:</h3>
<ul>
  <li>Phone number</li>
  <li>Invoice address</li>
  <li>Email address</li>
  <li>Payment method</li>
  <li>Order history</li>

  <li>
  Via our web shop we always enable you to ask questions via different channels (such as chat, email, telephone and social media).
  You are the one to decide which information you provide when you use one of these channels.
  </li>
</ul>

<h1>Accessing and changing your data</h1>
<h3>
If you have any questions regarding our privacy policy or questions about access to, changes made to (or removal of) your personal data,
you can contact us at any time via the information listed below.
To prevent abuse we may ask you to identify yourself adequately.
We want to prevent anyone from having control over your personal information.
It is best to submit your request by email.
</h3>
<b>
Want to talk to an actual human being? Please contact our customer service department on working days at "Number"
</b>
<h1>  </h1>
<b>
Prefer to send us an email? Send an email to "Email".
</b>

      </div>
    );
    
  }