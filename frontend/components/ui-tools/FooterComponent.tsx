import { Link } from 'react-router-dom';

const FooterComponent = () => {
  return (
    <div className='m-auto  w-[1440px]'>
        <div className='flex justify-between font-medium text-lg tracking-wider font-epunda'>
            <div>
                <ul>
                    <Link to="#"><li>Terms & Conditions</li></Link>
                    <Link to="#"><li>Privacy Policy</li></Link>
                    <Link to="#"><li>Shipping Policy</li></Link>
                    <Link to="#"><li>Terms & Service</li></Link>
                    <Link to="#"><li>Refund Policy</li></Link>
                </ul>
            </div>
            <div className='font-epunda'>
                <h2>SIGN UP AND SAVE</h2>
                <p>Sign up for the lates news, offers and styles</p>
                
            </div>
        </div>
        <p className='text-center py-5 text-slate-300'>&copy; 2025 .Pusthaka. All rights reserved.</p>
    </div>
  )
}

export default FooterComponent;