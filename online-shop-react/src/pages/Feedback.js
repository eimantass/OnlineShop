import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Feedback() {
  const { t } = useTranslation();
  return (
    <div>
       <Categories/>
      <h1> {t('feedback')}</h1>
      
    </div>
      
    );
    
  }